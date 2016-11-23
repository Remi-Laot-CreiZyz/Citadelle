package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class CourDesMiracles extends Merveille {
    private boolean dernierTour;

    public CourDesMiracles() {
        super("cour des miracles", 2, "Pour le décompte final des points, la cour des miracles est considérée comme un quartier de la couleur de votre choix. Vous ne pouvez pas utilisez cette capacité si vous avez construit la cour des miracles au dernier tour de jeu.");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {
        this.dernierTour = false;
    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        this.dernierTour = true;
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {

    }

    @Override
    public int calculScore(Joueur j){
        if (this.dernierTour) {
            List<String> liste = new ArrayList<String>();
            liste.add("vert");
            liste.add("bleu");
            liste.add("violet");
            liste.add("jaune");
            liste.add("rouge");
            String couleur = j.choisirElement(liste, "quelle couleur voulez vous donner à la cour des miracles?", true);
            this.couleur = couleur;
        }
        return this.getCout();
    }
}
