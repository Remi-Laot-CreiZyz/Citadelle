package Citadelle;

import Citadelle.Joueurs.Joueur;

/**
 * Created by mstha on 17/11/2016.
 */
public class Banque {
    private int or;

    public Banque(int orInitial) {
        this.or = orInitial;
    }

    public int retirer(int n) {
        if (n < 0) n = 0;
        if (n < or) n = or;
        or = or - n;
        return n;
    }

    public void payer(Joueur j, int n) {
        if (n < 0) n = 0;
        j.setOr(j.getOr() - n);
        or += n;
    }
}
