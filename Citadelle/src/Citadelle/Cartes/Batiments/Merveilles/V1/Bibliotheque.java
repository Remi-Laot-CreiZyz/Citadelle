package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Bibliotheque extends Merveille{
    public Bibliotheque() {
        super("bibliotheque", 6, "Si vous choisissez de piocher des cartes au début de votre tour, vous en piochez deux et les conservez toutes les deux");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {
    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {
    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        j.setMaxNbCartesGardees(j.getMaxNbCartesGardees() + 1);
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {
        j.setMaxNbCartesGardees(j.getMaxNbCartesGardees() - 1);
    }
}
