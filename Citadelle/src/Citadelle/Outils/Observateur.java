package Citadelle.Outils;

/**
 * Created by mstha on 17/11/2016.
 */
public interface Observateur {
    void notifierChangement(Observe o, Object... arg) throws Exception;
}
