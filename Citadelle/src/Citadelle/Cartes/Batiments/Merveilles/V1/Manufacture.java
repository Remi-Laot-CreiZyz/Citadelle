package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Actions.Action;
import Citadelle.Actions.Effet;
import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Manufacture extends Merveille{
    public Manufacture() {
        super("manufacture", 5, "Une fois par tour, vous pouvez payer trois pièces d'or pour piocher trois cartes.");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {
        p.ajoutActionDisponnible(new Action("pioche manufacture", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                if (j.getOr() >= 3) {
                    j.setOr(j.getOr() - 3);
                    j.cartesEnMain().addAll(Moteur.getInstance().getDonneesPartie().getPaquet().piocher(3));
                }
            }
        }), "racine");
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
