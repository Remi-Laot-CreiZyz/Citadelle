package Citadelle.Cartes.Personnages.V1;

import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Evenements.Evenement;
import Citadelle.Evenements.EvenementAssassin;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.List;

/**
 * Created by mstha on 17/11/2016.
 */
public class Assassin extends Personnage {
    private Evenement evenement;

    public Assassin() {
        super("assassin", 1, "assassine un autre personnage");
        this.evenement = null;
    }

    @Override
    protected void onNouveauTourSpecifique(Joueur j) {
        List<Personnage> personnages = Moteur.getInstance().getDonneesPartie().getPersonnages();
        List<Personnage> victimesPotentielles = personnages.subList(1, personnages.size());
        Personnage cible = j.choisirElement(victimesPotentielles, "quel personnage souhaitez vous assassiner?", true);
        this.evenement = new EvenementAssassin(this, cible);
    }

    @Override
    protected void genererActionsSpecifique() {
    }

    @Override
    protected void onFinTourSpecifique(Joueur j) {
    }

    public Evenement getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Evenement e) {
        this.evenement = e;
    }
}
