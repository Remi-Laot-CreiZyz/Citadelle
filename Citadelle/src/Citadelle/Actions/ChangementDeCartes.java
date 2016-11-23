package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;
import Citadelle.DonneesPartie;

import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class ChangementDeCartes extends Action {
    public ChangementDeCartes() {
        super("changement de cartes", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                if (Moteur.getInstance().verbose > 2) System.out.println(" nombre de joueurs avant changement de cartes: " + Moteur.getInstance().getDonneesPartie().getNbJoueurs());
                DonneesPartie donneesPartie = Moteur.getInstance().getDonneesPartie();
                if (Moteur.getInstance().verbose > 2) System.out.println("   avant choix multiples dans action changement de cartes");
                List<Batiment> listeChoix =  j.choisirElements(j.cartesEnMain(), 1, donneesPartie.getPaquet().getNombreCartes(), "quelles cartes souhaitez vous changer?", false);
                if (Moteur.getInstance().verbose > 2) System.out.println("   apres choix multiples dans action changement de cartes");
                if (listeChoix != null) {
                    j.cartesEnMain().removeAll(listeChoix);
                    j.cartesEnMain().addAll(donneesPartie.getPaquet().piocher(listeChoix.size()));
                }
                p.supprimerActionDisponnible("echange de main");
                if (Moteur.getInstance().verbose > 2) System.out.println(" nombre de joueurs apres changement de cartes: " + Moteur.getInstance().getDonneesPartie().getNbJoueurs());
            }
        });
    }
}
