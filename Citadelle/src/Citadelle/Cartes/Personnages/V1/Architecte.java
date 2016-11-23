package Citadelle.Cartes.Personnages.V1;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Architecte extends Personnage {
    public Architecte() {
        super("architecte", 7, "pioche deux cartes gratuitement ET peut batir jusqu'à trois batiments");
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {
        List<Batiment> mainJoueur = j.cartesEnMain();
        mainJoueur.addAll(Moteur.getInstance().getDonneesPartie().getPaquet().piocher(2));
        j.setMaxNbConstrParTour(j.getMaxNbConstrParTour() + 2);
    }

    @Override
    protected void genererActionsSpecifique() {

    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {
        j.setMaxNbConstrParTour(j.getMaxNbConstrParTour() - 2);
    }
}
