package Citadelle.Outils;

import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Observe {
    private List<Observateur> listeObservateurs;

    public final void declarerObservateur(Observateur o) {
        this.listeObservateurs.add(o);
    }

    public final void revoquerObservateur(Observateur o) {
        while (this.listeObservateurs.remove(o));
    }

    protected final void notifierObservateurs(Observe o, Object... arg){
        try {
            for (Observateur obs : listeObservateurs) obs.notifierChangement(o, arg);
        }
        catch (Exception e) {
            // TODO
        }
    }
}
