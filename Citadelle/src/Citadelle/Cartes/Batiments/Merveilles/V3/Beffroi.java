package Citadelle.Cartes.Batiments.Merveilles.V3;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Beffroi extends Merveille {
    public Beffroi() {
        super("beffroi", 5, "lorsque vous posez le beffroi dans votre cité, vous pouvez décider de réduire la durée de la partie en sept batiments au lieu de huit");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {

    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        Moteur.getInstance().getDonneesPartie().setDuree(Moteur.getInstance().getDonneesPartie().getDuree() - 1);
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {
        Moteur.getInstance().getDonneesPartie().setDuree(Moteur.getInstance().getDonneesPartie().getDuree() + 1);
    }
}
