package Citadelle;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Outils.Observe;

import java.util.*;

/**
 * Created by mstha on 17/11/2016.
 */
public class Moteur extends Observe{
    private Random rand;
    public int verbose;
    // SINGLETON -------------------------------------------------------------------------------------------------------
    private static Moteur instance = null;
    public static Moteur getInstance() {
        if (instance == null) instance = new Moteur();
        return instance;
    }
    private Moteur() {
        rand = new Random();
    }
    // ETAT ------------------------------------------------------------------------------------------------------------
    private DonneesPartie donneesPartie;
    public DonneesPartie getDonneesPartie() {
        return donneesPartie;
    }
    // LOGIQUE DE JEU --------------------------------------------------------------------------------------------------
    private void distributionPersonnages() {
        List<Personnage> personnagesRestant = new ArrayList<Personnage>();
        List<Personnage> personnagesVisibles = new ArrayList<Personnage>();
        List<Personnage> personnagesCachees = new ArrayList<Personnage>();
        personnagesRestant.addAll(getDonneesPartie().getPersonnages());
        List<Joueur> joueurs = getDonneesPartie().getJoueurs();
        int joueurCourant = joueurs.indexOf(getDonneesPartie().getPremierJoueur());
        // visible random discard before character distribution
        for (int n = getDonneesPartie().getNbPersonnagesEcartes(0); n > 0; n--) {
            int i = 0;
            do i = rand.nextInt(personnagesRestant.size());
            while (personnagesRestant.get(i).getNom().equals("roi"));
            personnagesVisibles.add(personnagesRestant.remove(i));
        }

        // hidden random discard before character distribution
        for (int n = getDonneesPartie().getNbPersonnagesEcartes(1); n > 0; n--) {
            int i = rand.nextInt(personnagesRestant.size());
            personnagesCachees.add(personnagesRestant.remove(i));
        }

        // character distribution
        for (int n = getDonneesPartie().getNbToursDistribution() * getDonneesPartie().getNbJoueurs(); n > 0; n--) {
            // discard before picking characters (except for 1rst player)
            if (n != getDonneesPartie().getNbToursDistribution() * getDonneesPartie().getNbJoueurs() && n > getDonneesPartie().getNbToursDistribution() - 1) {
                int nbEcartes = getDonneesPartie().getNbPersonnagesEcartes(2);
                for (int i = 0; i < nbEcartes; i++) {
                    Personnage choix = null;
                    if (personnagesRestant.size() > 0) {
                        while (choix == null)
                            choix = joueurs.get(joueurCourant).choisirElement(personnagesRestant, "quel personnage souhaitez vous écarter?", true);
                        personnagesCachees.add(choix);
                        personnagesRestant.remove(choix);
                    }
                }
            }
            // picking characters
            Personnage choix = null;
            if (personnagesRestant.size() > 0) {
                while (choix == null)
                    choix = joueurs.get(joueurCourant).choisirElement(personnagesRestant, "quel personnage souhaitez vous jouer?", true);
                personnagesRestant.remove(choix);
                getDonneesPartie().setJoueur(choix, joueurs.get(joueurCourant));
            }
            joueurCourant = (joueurCourant + 1) % getDonneesPartie().getNbJoueurs();
        }
    }
    private void tourPersonnages()
    {
        notifierObservateurs(this, "debut de tour", "avant");

        for (Personnage p : getDonneesPartie().getPersonnages()) {
            Joueur j = getDonneesPartie().getJoueur(p);
            if (j != null) {
                if (verbose > 1) System.out.println(j.getNom() + " joue le personnage " + p.getNom());
                if (verbose > 2) System.out.println("nombre de joueurs avant le tour: " + getDonneesPartie().getNbJoueurs());
                p.executerTour(j);
                if (verbose > 2) System.out.println("nombre de joueurs après le tour: " + getDonneesPartie().getNbJoueurs());
            }
        }
        notifierObservateurs(this, "fin de tour", "apres");
    }
    public static void demarrer(String config, int verbose)
    {
        if (verbose > 0) System.out.println("\nCitadelle - nouvelle partie!");
        Moteur m = getInstance();
        if (verbose > 0) System.out.println("initialisation...");
        m.init(config, verbose);
        if (verbose > 0) {
            String liste = "liste des joueurs :";
            for (Joueur j : m.getDonneesPartie().getJoueurs()) liste += " " + j.getNom() + ",";
            System.out.println(liste);
            System.out.println("demarrage de la partie...");
        }
        m.boucleDeJeu();
        if (verbose > 0) {
            System.out.println("résultats:");
            Map<Joueur, Integer> scores = m.getDonneesPartie().calculScores();
            for (Joueur j : scores.keySet())
                System.out.println(" - " + j.getNom() + " : " + scores.get(j) + " points.");
            System.out.println("");
        }
    }

    public static void clean() {
        instance = new Moteur();
    }

    private void init(String config, int verbose) {
        this.verbose = verbose;
        LecteurConfiguration lecteur = new LecteurConfiguration(config);
        // INIT DONNEES PARTIE
        this.donneesPartie = new DonneesPartie(lecteur.genererListeJoueurs(), lecteur.genererListePersonnages(), lecteur.genererListeBatiments(), lecteur.extraireOrInitialBanque(), lecteur.extraireDureeInitiale());
        int n = rand.nextInt(getDonneesPartie().getNbJoueurs());
        // INIT JOUEURS
        getDonneesPartie().setPremierJoueur(getDonneesPartie().getJoueurs().get(n));
        for (Joueur j : getDonneesPartie().getJoueurs()) {
            j.setOr(lecteur.extraireOr());
            j.setMaxNbCartesTirees(lecteur.extraireMaxNbCartesTirees());
            j.setMaxNbCartesGardees(lecteur.extraireMaxNbCartesGardees());
            j.setMontantRevenu(lecteur.extraireMontantRevenu());
            j.setMaxNbConstrParTour(lecteur.extraireMaxNbConstrParTour());
            j.setMaxNbConstrIdentique(lecteur.extraireMaxNbConstrIdentique());
            j.cartesEnMain().addAll(donneesPartie.getPaquet().piocher(lecteur.extraireNbCartesInitial()));
        }
    }

    public void boucleDeJeu() {
        List<Joueur> l = getDonneesPartie().getJoueurs(getDonneesPartie().getDuree());
        while (getDonneesPartie().getJoueurs(getDonneesPartie().getDuree()).size() < 1) {
            if (verbose > 1) System.out.println("\ndebut d'un nouveau tour");
            getDonneesPartie().nouveauTour();
            if (verbose > 1) System.out.println("distribution des personnages...");
            distributionPersonnages();
            if (verbose > 1) System.out.println("tour des personnages...");
            tourPersonnages();
        }
    }
}
