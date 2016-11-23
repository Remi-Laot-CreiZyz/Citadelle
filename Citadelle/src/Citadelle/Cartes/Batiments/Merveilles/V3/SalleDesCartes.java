package Citadelle.Cartes.Batiments.Merveilles.V3;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class SalleDesCartes extends Merveille{
    public SalleDesCartes() {
        super("salle des cartes", 5, "a la fin de la partie, vous marquez 1 point de victoire supplementaire pour chaque carte dans votre main");
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
