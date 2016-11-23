package Citadelle.Cartes.Batiments.Merveilles.V2;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Carriere extends Merveille{
    public Carriere() {
        super("carriere", 5, "vous pouvez batire un batiment du meme nom de l'un de vos batiments déjà en jeu. Vous ne perdez pas les batiments ainsi construits si la carriere est détruite");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {

    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {

    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {

    }
}
