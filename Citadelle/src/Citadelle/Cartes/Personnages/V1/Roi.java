package Citadelle.Cartes.Personnages.V1;

import Citadelle.Actions.RevenuSpecial;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Roi extends Personnage {
    public Roi() {
        super("roi", 4, "ses quartiers nobles génèrent de l'or ET devient le premier joueur");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {
        Moteur.getInstance().getDonneesPartie().setPremierJoueur(j);
    }

    @Override
    protected void genererActionsSpecifique() {
        this.ajoutActionDisponnible(new RevenuSpecial("jaune"), "racine");
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
