package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Observatoire extends Merveille{
    public Observatoire() {
        super("observatoire", 5, "Si vous choisissez de piocher des cartes au début de votre tour, vous en piochez trois, en choisissez une et défaussez les deux autres.");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {

    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        j.setMaxNbCartesTirees(j.getMaxNbCartesTirees() + 1);
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {
        j.setMaxNbCartesTirees(j.getMaxNbCartesTirees() - 1);
    }
}
