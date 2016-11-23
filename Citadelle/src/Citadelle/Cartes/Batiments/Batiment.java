package Citadelle.Cartes.Batiments;

import Citadelle.Cartes.Carte;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

/**
 * Classe abstraite qui représente un batiment.
 * cf. "BatimentSimple" et "Merveille"
 */
public abstract class Batiment extends Carte {
    private int cout;
    protected String couleur;

    /**
     * Constructeur unique d'un batiment
     * @param nom le nom du batiment
     * @param cout le cout du batiment
     * @param couleur la couleur du batiment
     * @param description la description du batiment
     */
    public Batiment(String nom, int cout, String couleur, String description){
        super(nom, description);
        this.cout = cout;
        this.couleur = couleur;
    }

    /**
     * Accesseur du cout
     * @return le cout du batiment
     */
    public int getCout() {
        return this.cout;
    }

    /**
     * Accesseur de la couleur
     * @return la couleur du batiment
     */
    public String getCouleur() {
        return this.couleur;
    }

    /**
     * Méthode déclenchée au début du tour du joueur qui controle le batiment
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui controle le batiment
     */
    public abstract void onNouveauTour(Personnage p, Joueur j);

    /**
     * Méthode déclenchée à la fin du tour du joueur qui controle le batiment
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui controle le batiment
     */
    public abstract void onFinTour(Personnage p, Joueur j);

    /**
     * Méthode déclenchée avant la construction du batiment par un joueur
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui va construire le batiment
     */
    public abstract void onConstruction(Personnage p, Joueur j);

    /**
     * Méthode déclenchée après la construction d'un batiment par un joueur
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui va construire le batiment
     */
    public abstract void onDestruction(Personnage p, Joueur j);

    /**
     * Méthode de calcul des points générés par un batiment
     * Un batiment simple génère son cout en points
     * @param j le joueur pour lequel le batiment génère les points
     * @return les points générés par le batiment
     */
    public int calculScore(Joueur j) {
        return this.getCout();
    }
}
