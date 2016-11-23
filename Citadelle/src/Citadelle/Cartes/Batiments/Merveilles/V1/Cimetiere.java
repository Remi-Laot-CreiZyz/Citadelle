package Citadelle.Cartes.Batiments.Merveilles.V1;

import Citadelle.Cartes.Batiments.Merveilles.Merveille;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Evenements.Evenement;
import Citadelle.Evenements.EvenementCimetierre;
import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Cimetiere extends Merveille{
    private Evenement evenement;

    public Cimetiere() {
        super("cimetiere", 5, "Lorsque le Condottière détruit un quartier, vous pouvez payer une pièce d'or pour le reprendre dans votre main. Vous ne pouvez pas faire cela si vous êtes vous-même Condottiere.");
    }

    @Override
    public void onNouveauTour(Personnage p, Joueur j) {

    }

    @Override
    public void onFinTour(Personnage p, Joueur j) {

    }

    @Override
    public void onConstruction(Personnage p, Joueur j) {
        this.evenement = new EvenementCimetierre(j);
    }

    @Override
    public void onDestruction(Personnage p, Joueur j) {
        this.evenement.detruire();
    }
}
