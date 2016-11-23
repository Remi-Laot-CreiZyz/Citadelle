package Citadelle.Cartes.Batiments.Merveilles;

import Citadelle.Cartes.Batiments.Batiment;

/**
 * Created by mstha on 17/11/2016.
 */
public abstract class Merveille extends Batiment {
    /**
     * Constructeur unique d'un batiment
     *
     * @param nom         le nom du batiment
     * @param cout        le cout du batiment
     * @param description la description du batiment
     */
    public Merveille(String nom, int cout, String description) {
        super(nom, cout, "violet", description);
    }
}
