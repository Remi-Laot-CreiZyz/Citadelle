package Citadelle.Evenements;

import Citadelle.Cartes.Personnages.V1.Assassin;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class EvenementAssassin extends Evenement {
    private Assassin source;
    private Personnage cible;

    public EvenementAssassin(Assassin source, Personnage cible) {
        this.source = source;
        this.cible = cible;
        this.setAutodestruction(true);
        this.declarerDeclencheur(this.cible);
        this.declarerDeclencheur(Moteur.getInstance());
    }

    @Override
    public boolean evenementDeclencheParPersonnage(Personnage p, Joueur j, String e, String t) {
        if (p.equals(cible) && e.equals("debut de tour") && t.equals("avant")) {
            p.setTourFini(true);
            if (!cible.getNom().equals("roi")) this.detruire();
            return true;
        }
        return false;
    }

    @Override
    public boolean evenemenDeclenchePartMoteur(Moteur m, String e, String t) {
        if (e.equals("fin de tour") && t.equals("avant")) {
            if (cible.getNom().equals("roi")) Moteur.getInstance().getDonneesPartie().setPremierJoueur(Moteur.getInstance().getDonneesPartie().getJoueur(cible));
            this.detruire();
            return true;
        }
        return false;
    }
}
