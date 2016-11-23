package Citadelle.Outils;

import Citadelle.Actions.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Arbre<T> {
    private T donnee;
    private List<Arbre<T>> listeSuccesseurs;

    public Arbre(T donnee) {
        this.donnee = donnee;
        this.listeSuccesseurs = new ArrayList<>();
    }

    public void ajoutMultiple(T donnee, T parent) {
        if (donnee != null) {
            if (this.donnee.equals(parent)) listeSuccesseurs.add(new Arbre<T>(donnee));
            for (Arbre<T> a : listeSuccesseurs) a.ajoutMultiple(donnee, parent);
        }
    }

    public List<Arbre<T>> successeurs() {
        return this.listeSuccesseurs;
    }

    public T getDonnee() {
        return this.donnee;
    }

    public List<T> donneesSuccesseurs() {
        List<T> l = new ArrayList<T>();
        for (Arbre<T> a : this.successeurs()) l.add(a.getDonnee());
        return l;
    }

    public void supressionMultiple(T donnee) {
        if (donnee != null) {
            List<Arbre<T>> aSupprimer = new ArrayList<Arbre<T>>();
            for (Arbre<T> a : listeSuccesseurs) if (a.getDonnee().equals(donnee)) aSupprimer.add(a);
            for (Arbre<T> a : aSupprimer) listeSuccesseurs.remove(a);
            for (Arbre<T> a : listeSuccesseurs) a.supressionMultiple(donnee);
        }
    }

    public boolean contient(T donnee) {
        if (donnee == null) return false;
        boolean b = (this.donnee.equals(donnee));
        for (Arbre<T> a : listeSuccesseurs) b = b || a.contient(donnee);
        return b;
    }

    public Arbre<T> getDansSuccesseurs(T donnee) {
        for (Arbre<T> a : successeurs()) if (a.getDonnee().equals(donnee)) return a;
        return null;
    }
}
