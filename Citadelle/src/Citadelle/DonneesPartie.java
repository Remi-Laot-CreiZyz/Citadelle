package Citadelle;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mstha on 23/11/2016.
 */
public class DonneesPartie {
    // OBJETS GLOBAUX "CONSTANTS" --------------------------------------------------------------------------------------
    private final List<Joueur> listeJoueurs;
    private final List<Personnage> listePersonnages;
    private final Banque banque;
    private final Paquet paquet;
    private final int nbToursDistribution;
    private int[] nbPersonnagesEcartes;
    private int dureePartie;
    // CONSTRUCTEUR ----------------------------------------------------------------------------------------------------
    public DonneesPartie(List<Joueur> listeJoueurs, List<Personnage> listePersonnages, List<Batiment> listeBatiments, int orInitial, int dureeInitiale){
        this.listeJoueurs = listeJoueurs;
        Collections.sort(listePersonnages);
        this.listePersonnages = listePersonnages;
        this.paquet = new Paquet(listeBatiments);
        this.banque = new Banque(orInitial);
        this.dureePartie = dureeInitiale;

        if (listeJoueurs.size() == 2) nbToursDistribution = 2;
        else if (listeJoueurs.size() == 3) nbToursDistribution = 2;
        else if (listeJoueurs.size() == 4) nbToursDistribution = 1;
        else if (listeJoueurs.size() == 5) nbToursDistribution = 1;
        else if (listeJoueurs.size() == 5) nbToursDistribution = 1;
        else if (listeJoueurs.size() == 6) nbToursDistribution = 1;
        else if (listeJoueurs.size() == 7) nbToursDistribution = 1;
        else nbToursDistribution = 1;

        nbPersonnagesEcartes = new int[3];
        if (listeJoueurs.size() == 2) {
            nbPersonnagesEcartes[0] = 0;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 1;
        } else if (listeJoueurs.size() == 3) {
            nbPersonnagesEcartes[0] = 0;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        } else if (listeJoueurs.size() == 4) {
            nbPersonnagesEcartes[0] = 2;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        } else if (listeJoueurs.size() == 5) {
            nbPersonnagesEcartes[0] = 1;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        } else if (listeJoueurs.size() == 6) {
            nbPersonnagesEcartes[0] = 0;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        } else if (listeJoueurs.size() == 7) {
            nbPersonnagesEcartes[0] = 0;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        } else { // 8
            nbPersonnagesEcartes[0] = 0;
            nbPersonnagesEcartes[1] = 1;
            nbPersonnagesEcartes[2] = 0;
        }
    }
    // ACCESSEURS REGULIERS --------------------------------------------------------------------------------------------
    public List<Joueur> getJoueurs() {
        return this.listeJoueurs;
    }
    public List<Joueur> getJoueurs(int auMoinsNbBatimentsConstruits) {
        return getJoueurs().stream().filter(j -> j.batimentsConstruits().size() >= auMoinsNbBatimentsConstruits).collect(Collectors.toList());
    }
    public List<Personnage> getPersonnages() {
        return this.listePersonnages;
    }
    public int getNbJoueurs() {
        return listeJoueurs.size();
    }
    public Banque getBanque() {
        return banque;
    }
    public Paquet getPaquet() {
        return paquet;
    }
    public int getNbToursDistribution() {
        return nbToursDistribution;
    }
    public int getNbPersonnagesEcartes(int phaseDistribution) {
        return nbPersonnagesEcartes[phaseDistribution];
    }
    public int getDuree() {
        return dureePartie;
    }
    public void setDuree(int i) {
        dureePartie = i;
    }
    // VARIABLES DE TOUR -----------------------------------------------------------------------------------------------
    private Joueur premierJoueur;
    private Map<Personnage, Joueur> distributionPersonnages;
    // ACCESSEURS VARIABLES DE TOUR ------------------------------------------------------------------------------------
    public List<Personnage> getPersonnages(Joueur j) {
        return (j == null)? null : distributionPersonnages.keySet().stream().filter(p -> distributionPersonnages.get(p).equals(j)).collect(Collectors.toList());
    }
    public Personnage getPersonnage(String nom) {
        for (Personnage p : listePersonnages) if (p.getNom().equals(nom)) return p;
        return null;
    }
    public Joueur getJoueur(Personnage p) {
        return (p == null)? null : distributionPersonnages.get(p);
    }
    public Joueur getPremierJoueur() {
        return premierJoueur;
    }
    public void setPremierJoueur(Joueur j) {
        premierJoueur = j;
    }
    public void setJoueur(Personnage p, Joueur j) {
        this.distributionPersonnages.put(p, j);
    }
    public void nouveauTour() {
        this.distributionPersonnages = new HashMap<>();
    }
    public Map<Joueur, Integer> calculScores() {
        Map<Joueur, Integer> scores = new HashMap<>();
        List<Joueur> joueursLimiteBatiments = getJoueurs(getDuree());
        for (Joueur j : getJoueurs())
            scores.put(j, j.batimentsConstruits().stream().map(b -> b.calculScore(j)).reduce(0, (a,b) -> a + b));
        return scores;
    }
}
