package Citadelle.Cartes;

import Citadelle.Outils.Observe;

/**
 * Created by mstha on 17/11/2016.
 * TODO comments
 */
public abstract class Carte extends Observe{
    private String nom;
    private String description;

    public Carte(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.getNom() + ": " + this.getDescription();
    }

    public String shortString() {
        return this.getNom();
    }

    public boolean equals(Object o) {
        return this.getNom().equals(((Carte) o).getNom());
    }

}
