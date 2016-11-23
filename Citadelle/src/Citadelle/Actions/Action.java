package Citadelle.Actions;

import Citadelle.Joueurs.Joueur;
import Citadelle.Cartes.Personnages.Personnage;

/**
 * Created by mstha on 17/11/2016.
 */
public class Action{
    private String nom;
    private Effet effet;

    public Action(String nom, Effet effet) {
        this.nom = nom;
        this.effet = effet;
    }

    public void declencher(Personnage p, Joueur j) {
        if (effet != null) effet.appliquer(p, j);
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        return this.nom;
    }

    public boolean equals(Object o) {
        return this.getNom().equals(((Action)o).getNom());
    }
}
