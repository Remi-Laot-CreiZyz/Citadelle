package Citadelle.Cartes.Personnages.V1;

import Citadelle.Actions.ChangementDeCartes;
import Citadelle.Actions.EchangeDeMain;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Magicien extends Personnage {
    public Magicien() {
        super("magicien", 3, "echange ses cartes avec un joueur OU change des cartes de sa main");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {

    }

    @Override
    protected void genererActionsSpecifique() {
        this.ajoutActionDisponnible(new EchangeDeMain(), "racine");
        this.ajoutActionDisponnible(new ChangementDeCartes(), "racine");
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
