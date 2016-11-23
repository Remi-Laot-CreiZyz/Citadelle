package Citadelle.Cartes.Batiments.Merveilles.V3;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Musee extends Merveille{
    public Musee() {
        super("musee", 4, "a la fin de votre tour, vous pouvez placer un batiment de votre main sous le musee, face cache. A la fin du jeu, vous gagnez un point supplementaire par batiment places sous le musée");
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
