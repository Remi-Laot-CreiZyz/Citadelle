package Citadelle.Cartes.Batiments.Merveilles.V2;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class TresorImperial extends Merveille{
    public TresorImperial() {
        super("tresor imperial", 4, "a la fin de la partie, vous marquez un point suplémentaire pour chaque piece d'or en votre prossession");
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
