package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class EchangeDeMain extends Action {
    public EchangeDeMain() {
        super("echange de main", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                if (Moteur.getInstance().verbose > 2) System.out.println(" nombre de joueurs avant echange de main: " + Moteur.getInstance().getDonneesPartie().getNbJoueurs());
                List<Joueur> ciblesPotentielles = new ArrayList<Joueur>(Moteur.getInstance().getDonneesPartie().getJoueurs());
                ciblesPotentielles.remove(j);
                Joueur cible = j.choisirElement(ciblesPotentielles, "avec quel joueur souhaitez vous échanger votre main?", true);
                List<Batiment> tmp = j.cartesEnMain();
                j.setCartesMain(cible.cartesEnMain());
                cible.setCartesMain(tmp);
                p.supprimerActionDisponnible("changement de cartes");
                if (Moteur.getInstance().verbose > 2) System.out.println(" nombre de joueurs apres echange de main: " + Moteur.getInstance().getDonneesPartie().getNbJoueurs());
            }
        });
    }
}
