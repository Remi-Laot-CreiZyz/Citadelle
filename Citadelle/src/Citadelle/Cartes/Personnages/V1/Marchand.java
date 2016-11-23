package Citadelle.Cartes.Personnages.V1;

import Citadelle.Actions.RevenuSpecial;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Marchand extends Personnage {
    public Marchand() {
        super("marchand", 6, "ses quartiers marchands génèrent de l'or ET gagne une pièce d'or");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {
        j.setOr(j.getOr() + Moteur.getInstance().getDonneesPartie().getBanque().retirer(1));
    }

    @Override
    protected void genererActionsSpecifique() {
        this.ajoutActionDisponnible(new RevenuSpecial("vert"), "racine");
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {

    }
}
