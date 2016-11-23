package Citadelle.Actions;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Construction extends Action {
    public Construction() {
        super("construction", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                boolean pass = false;
                int n = 0;
                while(!pass && n < j.getMaxNbConstrParTour()) {
                    List<Batiment> constructibles = new ArrayList<Batiment>();
                    for (Batiment b : j.cartesEnMain())
                        if (b.getCout() < j.getOr()){
                            int i = 0;
                            for (Batiment construit : j.batimentsConstruits())
                                if (construit.equals(b)) i++;
                            if (i <= j.getMaxNbConstrIdentique())
                                constructibles.add(b);
                        }
                    Batiment choix = j.choisirElement(constructibles, "quels batiments souhaitez vous construire?", false);
                    if (choix == null) pass = true;
                    else {
                        j.setOr(j.getOr() - choix.getCout());
                        j.cartesEnMain().remove(choix);
                        j.batimentsConstruits().add(choix);
                        n++;
                    }
                }
            }
        });
    }
}
