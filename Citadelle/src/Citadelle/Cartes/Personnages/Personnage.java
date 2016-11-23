package Citadelle.Cartes.Personnages;

import Citadelle.Actions.*;
import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Carte;
import Citadelle.Joueurs.Joueur;
import Citadelle.Outils.Arbre;

import java.util.List;

/**
 * Classe Personnage
 * TODO
 */
public abstract class Personnage extends Carte implements Comparable<Personnage>{
    // DONNEES GENERALES
    private int ordreTour;
    // LOGIQUE DE TOUR
    private boolean tourFini;
    private Arbre<Action> arbreActions;

    // CONSTRUCTEUR ----------------------------------------------------------------------------------------------------

    /**
     * Constructeur unique d'un personnage
     */
    public Personnage(String nom, int ordreTour, String description){
        // DONNEES GENERALES
        super(nom, description);
        this.ordreTour = ordreTour;
        // LOGIQUE DE TOUR
        this.regenererActions();
        this.tourFini = false;
    }

    // EVENEMENTS ------------------------------------------------------------------------------------------------------

    /**
     * Méthode déclenchée automatiquement au début du tour d'un personnage
     * @param j le joueur qui joue actuellement le tour du personnage
     */
    private void onNouveauTour(Joueur j) { // ajouter personnage dans les arguments?
        for (Batiment b : j.batimentsConstruits()) b.onNouveauTour(this, j);
        this.onNouveauTourSpecifique(j);
    }

    /**
     * Méthode déclenchée automatiquement à la fin du tour d'un personnage
     * @param j le joueur qui joue actuellement le tour du personnage
     */
    private void onFinTour(Joueur j) {
        this.onFinTourSpecifique(j);
        for (Batiment b : j.batimentsConstruits()) b.onFinTour(this, j);
        this.regenererActions();
        this.tourFini = false;
    }

    // EXECUTION TOUR --------------------------------------------------------------------------------------------------

    /**
     * Méthode qui notifie un personnage de la fin de son tour
     */
    public final void setTourFini(boolean v) {
        this.tourFini = v;
    }

    /**
     * Méthode d'execution du tour d'un personnage
     * note: Il est possible d'inscrire des observateurs qui seront notifiés par le personnage à plusieurs moments de son tour (cf. TODO)
     * @param j le joueur qui execute le tour du personnage
     */
    public final void executerTour(Joueur j) {
        this.notifierObservateurs(this, j, "nouveau tour", "avant");
        if (!tourFini) {
            this.onNouveauTour(j);
            this.notifierObservateurs(this, j, "nouveau tour", "apres");
            while (!tourFini) {
                Action a = j.choisirElement(this.arbreActions.donneesSuccesseurs(), "Quelle sera votre prochaine action?", true);
                this.notifierObservateurs(this, j, a.getNom(), "avant");
                a.declencher(this, j);
                List<Action> sousActions = this.arbreActions.getDansSuccesseurs(a).donneesSuccesseurs();
                for (Action sa : sousActions) ajoutActionDisponnible(sa, "racine");
                supprimerActionDisponnible(a.getNom());
                this.notifierObservateurs(this, j, a.getNom(), "apres");
            }
            this.notifierObservateurs(this, j, "fin de tour", "avant");
            this.onFinTour(j);
            this.notifierObservateurs(this, j, "fin de tour", "apres");
        }
    }

    // GESTION ACTIONS -------------------------------------------------------------------------------------------------

    /**
     * Ajoute une nouvelle action disponnible pour un personnage
     * @param a l'action à ajouter au personnage
     * @param nP le nom d'une action déjà présente dans l'abre d'action d'un personnage après laquelle ajouter la nouvelle action. Si plusieurs actions parentes sont trouvées dans l'abre, la nouvelle action a est ajoutée plusieur fois
     */
    public final void ajoutActionDisponnible(Action a, String nP) {
        // On utilise le fait que (Action a1 == Action a2) <==> (a1.getNom() == a2.getNom())
        this.arbreActions.ajoutMultiple(a, new Action(nP, null));
    }

    public void supprimerActionDisponnible(String nom) {
        this.arbreActions.supressionMultiple(new Action(nom, null));
    }

    /**
     * Régénère les actions d'un personnage
     * Les actions disponnibles durant le tour d'un personnage se détruisent au fur et à mesure qu'un joueur les
     * exécute. Elles sont donc régénérées à la fin du tour.
     */
    private void regenererActions() {
        Action racine = new Action("racine", null);
        Action fin = new Action("fin de tour", new Effet() {
            @Override
            public void appliquer(Personnage p, Joueur j) {
                p.setTourFini(true);
            }
        });

        Action pioche = new Pioche();
        Action revenu = new Revenu();
        Action construction = new Construction();

        this.arbreActions = new Arbre<Action>(racine);
        this.arbreActions.ajoutMultiple(pioche, racine);
        this.arbreActions.ajoutMultiple(revenu, racine);
        this.arbreActions.ajoutMultiple(construction, pioche);
        this.arbreActions.ajoutMultiple(construction, revenu);
        this.arbreActions.ajoutMultiple(fin, pioche);
        this.arbreActions.ajoutMultiple(fin, revenu);

        this.genererActionsSpecifique();
    }

    /**
     * Methode utilisée pour spécialiser un personnage
     * Utilisez cette méthode pour déclencher des évènements spécifiques au début du tour d'un personnage
     * La méthode "onNouveauTourSpecifique" est appelée *à la fin* de la méthode "onNouveauTour" d'un personnage
     * @param j le joueur qui joue le tour du personnage
     */
    protected abstract void onNouveauTourSpecifique(Joueur j);

    /**
     * Méthode utilisée pour spécialiser un personnage
     * Utilisez cette méthode pour ajouter des actions spécifiques à un personnage au début de chacun de ses tours
     */
    protected abstract void genererActionsSpecifique();

    /**
     * Méthode utilisée pour spécialiser un personnage
     * Utilisez cette méthode pour déclencher des évènements spécifiques à la fin du tour d'un personnage
     * La méthode "onFinTourSpécifique" est appelée *au début* de la méthode "onFinTour" d'un personnage
     * @param j
     */
    protected abstract void onFinTourSpecifique(Joueur j);

    public boolean actionsPossiblesContient(Action a) {
        return this.arbreActions.contient(a);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Personnage o) {
        return ordreTour - o.getOrdreTour();
    }

    /**
     *
     * @return
     */
    public int getOrdreTour() {
        return ordreTour;
    }
}
