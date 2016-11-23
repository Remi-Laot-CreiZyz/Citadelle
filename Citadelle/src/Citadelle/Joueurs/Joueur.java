package Citadelle.Joueurs;

import Citadelle.Cartes.Batiments.Batiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mstha on 17/11/2016.
 */
public abstract class Joueur {
    private String nom;
    private List<Batiment> listeBatimentsConstruits;
    private List<Batiment> listeBatimentsMain;

    private int or;

    private int maxNbCartesTirees;
    private int maxNbCartesGardees;
    private int montantRevenu;
    private int maxNbConstrParTour;
    private int maxNbConstrIdentique;

    private Map<String, Integer> bonusConstruction;
    private Map<String, Integer> malusDestruction;
    private List<Batiment> batimentsConstruits;


    /**
     * Constructeur unique d'un joueur
     * @param nom le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.listeBatimentsMain = new ArrayList<Batiment>();
        this.listeBatimentsConstruits = new ArrayList<Batiment>();
        this.bonusConstruction = new HashMap<String, Integer>();
        this.malusDestruction = new HashMap<String, Integer>();
    }

    // INTERACTIONS ----------------------------------------------------------------------------------------------------
    public abstract <T> T choisirElement(List<T> liste, String description, boolean obligatoire);
    public abstract <T> List<T> choisirElements(List<T> liste, int minChoix, int maxChoix, String description, boolean obligatoire);

    // ACCESSEURS ------------------------------------------------------------------------------------------------------
    public final List<Batiment> batimentsConstruits() {
        return this.listeBatimentsConstruits;
    }

    public final List<Batiment> cartesEnMain() {
        return this.listeBatimentsMain;
    }

    public final String getNom() {
        return this.nom;
    }

    public final void setNom(String nom) {
        this.nom = nom;
    }

    public final int getMaxNbCartesTirees() {
        return maxNbCartesTirees;
    }

    public final void setMaxNbCartesTirees(int maxNbCartesTirees) {
        this.maxNbCartesTirees = maxNbCartesTirees;
    }

    public final int getMaxNbCartesGardees() {
        return maxNbCartesGardees;
    }

    public final void setMaxNbCartesGardees(int maxNbCartesGardees) {
        this.maxNbCartesGardees = maxNbCartesGardees;
    }

    public final int getMontantRevenu() {
        return montantRevenu;
    }

    public final void setMontantRevenu(int montantRevenu) {
        this.montantRevenu = montantRevenu;
    }

    public final int getMaxNbConstrParTour() {
        return maxNbConstrParTour;
    }

    public final void setMaxNbConstrParTour(int maxNbConstrParTour) {
        this.maxNbConstrParTour = maxNbConstrParTour;
    }

    public final int getMaxNbConstrIdentique() {
        return maxNbConstrIdentique;
    }

    public final void setMaxNbConstrIdentique(int maxNbConstrIdentique) {
        this.maxNbConstrIdentique = maxNbConstrIdentique;
    }

    public final int getOr() {
        return or;
    }

    public final void setOr(int or) {
        this.or = or;
    }

    public final int getMalusDestruction() {
        return this.getMalusDestruction("general");
    }

    public final int getMalusDestruction(String couleur) {
        if (malusDestruction.get(couleur) != null) return malusDestruction.get(couleur);
        return 0;
    }

    public final int getBonusConstruction() {
        return this.getBonusConstruction("general");
    }

    public final int getBonusConstruction(String couleur) {
        if (malusDestruction.get(couleur) != null) return malusDestruction.get(couleur);
        return 0;
    }

    public final void setMalusDestruction(String couleur, int v) {
        malusDestruction.put(couleur, v);
    }

    public final void setMalusDestruction(int v) {
        setMalusDestruction("general", v);
    }

    public final void setBonusConstruction(String couleur, int v) {
        bonusConstruction.put(couleur, v);
    }

    public final void setBonusConstruction(int v) {
        setBonusConstruction("general", v);
    }

    public void setBatimentsConstruits(List<Batiment> batimentsConstruits) {
        this.batimentsConstruits = batimentsConstruits;
    }

    public void setCartesMain(List<Batiment> batimentsMain) {
        this.listeBatimentsMain = batimentsMain;
    }

    public String toString() {
        return this.getNom();
    }
}
