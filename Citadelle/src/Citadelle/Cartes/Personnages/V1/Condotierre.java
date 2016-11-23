package Citadelle.Cartes.Personnages.V1;

import Citadelle.Actions.Destruction;
import Citadelle.Actions.RevenuSpecial;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Condotierre extends Personnage {
    public Condotierre() {
        super("condotierre", 8, "ses quartiers militaires génèrent de l'or ET peut détruire un quartier");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {

    }

    @Override
    protected void genererActionsSpecifique() {
        this.ajoutActionDisponnible(new Destruction(), "racine");
        this.ajoutActionDisponnible(new RevenuSpecial("rouge"), "racine");
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
