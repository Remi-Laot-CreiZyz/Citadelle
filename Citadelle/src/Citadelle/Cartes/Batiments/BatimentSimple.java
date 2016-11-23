package Citadelle.Cartes.Batiments;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Outils.Observe;

/**
 * Created by mstha on 17/11/2016.
 */
public class BatimentSimple extends Batiment {
    /**
     * Constructeur unique d'un batiment
     *
     * @param nom         le nom du batiment
     * @param cout        le cout du batiment
     * @param couleur     la couleur du batiment
     * @param description la description du batiment
     */
    public BatimentSimple(String nom, int cout, String couleur, String description) {
        super(nom, cout, couleur, description);
    }

    /**
     * Méthode d'évènement déclenchée lors du tour du joueur qui controle le batiment
     * Un batiment simple ne déclenche aucun évènement
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui controle le batiment
     */
    @Override
    public void onNouveauTour(Personnage p, Joueur j) { }

    /**
     * Méthode d'évènement déclenchée lors du tour du joueur qui controle le batiment
     * Un batiment simple ne déclenche aucun évènement
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui controle le batiment
     */
    @Override
    public void onFinTour(Personnage p, Joueur j) { }

    /**
     * Méthode d'évènement déclenchée lors du tour du joueur qui controle le batiment
     * Un batiment simple ne déclenche aucun évènement
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui va construire le batiment
     */
    @Override
    public void onDestruction(Personnage p, Joueur j) { }

    /**
     * Méthode d'évènement déclenchée lors du tour du joueur qui controle le batiment
     * Un batiment simple ne déclenche aucun évènement
     * @param p le personnage actuellement joué par le joueur
     * @param j le joueur qui va construire le batiment
     */
    @Override
    public void onConstruction(Personnage p, Joueur j) { }

}
