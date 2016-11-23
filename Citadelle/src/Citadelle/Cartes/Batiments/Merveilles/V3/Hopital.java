package Citadelle.Cartes.Batiments.Merveilles.V3;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Hopital extends Merveille{
    public Hopital() {
        super("hopital", 6, "si vous etes assassiné, vous prennez quand même deux pieces d'ors ou une carte parmis deux, mais votre tour s'arrete ensuite");
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
