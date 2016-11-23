package Citadelle.Cartes.Batiments.Merveilles.V3;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Hospice extends Merveille{
    public Hospice() {
        super("hospice", 4, "si vous n'avez aucune pieces d'or a la fin de votre tour, recevez une piece de la banque");
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
