package Citadelle.Cartes.Batiments.Merveilles.V2;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class FontaineAuxSouhaits extends Merveille{
    public FontaineAuxSouhaits() {
        super("fontaine aux souhaits", 5, "en fin de partie, la fontaine aux souhaits vous rapporte 5 points plus 1 point pour chaque batiment violet en votre possession");
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
