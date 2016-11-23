package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;
import Citadelle.DonneesPartie;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Destruction extends Action {
    public Destruction() {
        super("destruction", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                DonneesPartie donneesPartie = Moteur.getInstance().getDonneesPartie();
                Joueur eveque = donneesPartie.getJoueur(donneesPartie.getPersonnage("eveque"));
                List<Joueur> listeJoueurs = donneesPartie.getJoueurs();
                List<Pair<Joueur, Batiment>> listeBatiments = new ArrayList<Pair<Joueur, Batiment>>();
                for (Joueur joueur : listeJoueurs)
                    if (eveque == null || !eveque.equals(joueur))
                        for (Batiment batiment : joueur.batimentsConstruits())
                            if (batiment.getCout() <= joueur.getOr() && !batiment.getNom().equals("donjon"))
                                listeBatiments.add(new Pair<Joueur, Batiment>(joueur, batiment));
                Pair<Joueur, Batiment> choix = (listeBatiments.size() > 0)? j.choisirElement(listeBatiments, "quel batiment souhaitez vous raser?", true) : null;
                if (choix != null) {
                    List<Batiment> batimentsJoueurCible = choix.getKey().batimentsConstruits();
                    batimentsJoueurCible.remove(choix.getValue());
                    choix.getKey().setBatimentsConstruits(batimentsJoueurCible);
                }
            }
        });
    }
}
