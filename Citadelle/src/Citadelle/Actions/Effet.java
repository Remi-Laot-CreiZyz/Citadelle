package Citadelle.Actions;

import Citadelle.Joueurs.Joueur;
import Citadelle.Cartes.Personnages.Personnage;

/**
 * Created by mstha on 17/11/2016.
 */
public interface Effet {
    void appliquer(Personnage p, Joueur j);
}
