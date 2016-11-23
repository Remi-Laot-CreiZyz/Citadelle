package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;
import Citadelle.DonneesPartie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Pioche extends Action {
    public Pioche() {
        super("pioche", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                DonneesPartie donneesPartie = Moteur.getInstance().getDonneesPartie();
                List<Batiment> disponnibles = new ArrayList<>(donneesPartie.getPaquet().piocher(j.getMaxNbCartesTirees()));
                List<Batiment> choix = (j.getMaxNbCartesGardees() < j.getMaxNbCartesTirees())? j.choisirElements(disponnibles, j.getMaxNbCartesGardees(), j.getMaxNbCartesGardees(), "quelles cartes souhaitez vous piocher?", true) : new ArrayList<>(disponnibles);
                for (Batiment b : choix) {
                    j.cartesEnMain().add(b);
                    disponnibles.remove(b);
                }
                for (Batiment b : disponnibles) if (!choix.contains(b)) donneesPartie.getPaquet().replacerALaFin(b);
                p.supprimerActionDisponnible("revenu");
            }
        });
    }
}
