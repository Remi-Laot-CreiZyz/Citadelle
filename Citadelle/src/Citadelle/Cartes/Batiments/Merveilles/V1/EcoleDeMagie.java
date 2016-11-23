package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Actions.RevenuSpecial;
import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Evenements.Evenement;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class EcoleDeMagie extends Merveille{

    public EcoleDeMagie() {
        super("ecole de magie", 6, "Pour la perception des revenus, l'école de magie est considérée comme un quartier de la couleur de votre choix, elle vous rapporte donc si vous êtes, Roi, Evêque, Marchand ou Condottiere");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {
        if (p.actionsPossiblesContient(new RevenuSpecial(""))) {
            List<String> liste = new ArrayList<String>();
            liste.add("vert");
            liste.add("bleu");
            liste.add("violet");
            liste.add("jaune");
            liste.add("rouge");
            String couleur = j.choisirElement(liste, "quelle couleur voulez vous donner à l'ecole de magie?", true);
            this.couleur = couleur;
        }
    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {
        this.couleur = "violet";
    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {

    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {

    }
}
