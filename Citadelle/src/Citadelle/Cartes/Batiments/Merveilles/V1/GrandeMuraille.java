package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class GrandeMuraille extends Merveille {
    public GrandeMuraille() {
        super("grande muraille", 6, "le prix a payer par le Condotierre pour détruire vos autres batiments est augmenté de 1");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {

    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        j.setMalusDestruction(j.getMalusDestruction("general") + 1);
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {
        j.setMalusDestruction(j.getMalusDestruction("general") - 1);
    }
}
