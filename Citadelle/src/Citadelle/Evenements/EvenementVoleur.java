package Citadelle.Evenements;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Cartes.Personnages.V1.Voleur;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

/**
 * Created by mstha on 17/11/2016.
 */
public class EvenementVoleur extends Evenement {
    private Voleur source;
    private Personnage cible;

    public EvenementVoleur(Voleur source, Personnage cible) {
        this.source = source;
        this.cible = cible;
        this.setAutodestruction(true);
        this.declarerDeclencheur(cible);
        this.declarerDeclencheur(Moteur.getInstance());
    }

    @Override
    public boolean evenementDeclencheParPersonnage(Personnage p, Joueur j, String e, String t) {
        if (p.equals(cible) && e.equals("debut de tour") && t.equals("apres")) {
            Joueur jSource = Moteur.getInstance().getDonneesPartie().getJoueur(source);
            if (jSource != null) {
                jSource.setOr(jSource.getOr() + j.getOr());
                j.setOr(0);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean evenemenDeclenchePartMoteur(Moteur m, String e, String t) {
        if (e.equals("fin de tour")) {
            this.detruire();
        }
        return false;
    }
}
