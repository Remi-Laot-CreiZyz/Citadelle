package Citadelle.Cartes.Personnages.V1;

import Citadelle.Actions.RevenuSpecial;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Eveque extends Personnage {
    public Eveque() {
        super("eveque", 5, "ses quartiers religieux génèrent de l'or ET il est protégé contre le Condotierre");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {

    }

    @Override
    protected void genererActionsSpecifique() {
        this.ajoutActionDisponnible(new RevenuSpecial("bleu"), "racine");
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
