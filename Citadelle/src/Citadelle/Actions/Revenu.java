package Citadelle.Actions;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Revenu extends Action {
    public Revenu() {
        super("revenu", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                j.setOr(j.getOr() + Moteur.getInstance().getDonneesPartie().getBanque().retirer(j.getMontantRevenu()));
                p.supprimerActionDisponnible("pioche");
            }
        });
    }
}
