package Citadelle.Cartes.Personnages.V2;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Sorciere extends Personnage {
    public Sorciere() {
        super("Sorciere", 1, "finit le tour d'un autre personnage à sa place");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {
        // TODO
    }

    @Override
    protected void genererActionsSpecifique() {

    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
