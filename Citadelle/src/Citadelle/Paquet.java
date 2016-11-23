package Citadelle;

import Citadelle.Cartes.Batiments.Batiment;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Paquet {
    private List<Batiment> paquet;

    public Paquet(List<Batiment> listeBatiments) {
        this.paquet = listeBatiments;
        Collections.shuffle(paquet);
    }

    public int getNombreCartes() {
        return this.paquet.size();
    }

    /**
     * Piocher une carte
     * @return la carte piochée (dans une liste)
     */
    public Batiment piocher() {
        List<Batiment> pioche = piocher(1);
        return (pioche.size() > 0)? pioche.get(0) : null;
    }

    /**
     * Méthode pour piocher des cartes
     * Si le paquet a moins de cartes disponnibles que le nombre demandé, la méthode renvoie le maximum de cartes disponnibles
     * @param size le nombre de cartes demandées
     * @return la liste des cartes piochées
     */
    public List<Batiment> piocher(int size) {
        if (size > paquet.size()) size = paquet.size();
        List<Batiment> pioche = paquet.subList(0, size);
        this.paquet = this.paquet.subList(size - 1, this.paquet.size());
        return pioche;
    }

    /**
     *
     * @return
     */
    public Batiment piocherDerniere() {
        List<Batiment> pioche = piocherDernieres(1);
        return (pioche.size() > 0)? pioche.get(0) : null;
    }

    /**
     *
     * @param size
     * @return
     */
    public List<Batiment> piocherDernieres(int size) {
        size = (size > paquet.size())? paquet.size() - size : paquet.size();
        List<Batiment> pioche = paquet.subList(size - 1, paquet.size());
        this.paquet = this.paquet.subList(0, size);
        return pioche;
    }

    public void replacerALaFin(Batiment b) {
        this.paquet.add(b);
    }

    public void replacerALaFin(List<Batiment> liste) {
        this.paquet.addAll(liste);
    }
}
