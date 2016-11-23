package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class RevenuSpecial extends Action {
    private String couleur;

    public RevenuSpecial(String couleur) {
        super("revenu special", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                int n = 0;
                List<Batiment> batiments = j.batimentsConstruits();
                for (Batiment b : batiments) if (b.getCouleur().equals(couleur)) n++;
                j.setOr(j.getOr() + Moteur.getInstance().getDonneesPartie().getBanque().retirer(n));
            }
        });
        this.couleur = couleur;
    }
}
