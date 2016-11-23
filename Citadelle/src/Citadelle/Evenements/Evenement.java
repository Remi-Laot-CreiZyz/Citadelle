package Citadelle.Evenements;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;
import Citadelle.Outils.Observateur;
import Citadelle.Outils.Observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public abstract class Evenement implements Observateur {
    private List<Observe> declencheurs;
    private boolean autodestruction;

    public Evenement() {
        this.declencheurs = new ArrayList<Observe>();
        this.autodestruction = false;
    }

    public final void setAutodestruction(boolean b) {
        this.autodestruction = b;
    }

    public final void declarerDeclencheur(Observe o) {
        this.declencheurs.add(o);
    }

    public final void detruire() {
        for (Observe o : declencheurs) o.revoquerObservateur(this);
    }

    @Override
    public final void notifierChangement(Observe o, Object... arg) {
        try {
            if (evenementDeclencheParPersonnage((Personnage) o, (Joueur) arg[0], (String) arg[1], (String) arg[2]) && autodestruction) this.detruire();
        }
        catch (Exception e0) {
            try {
                if (evenemenDeclenchePartMoteur((Moteur) o, (String) arg[0], (String) arg[1]) && autodestruction) this.detruire();
            }
            catch (Exception e1) {

            }
        }
    }

    public abstract boolean evenementDeclencheParPersonnage(Personnage p, Joueur j, String e, String t);
    public abstract boolean evenemenDeclenchePartMoteur(Moteur m, String e, String t);
}
