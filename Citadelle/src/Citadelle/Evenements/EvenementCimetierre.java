package Citadelle.Evenements;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.DonneesPartie;
import Citadelle.Joueurs.Joueur;
import Citadelle.Moteur;

import java.util.List;

/**
 * Created by mstha on 22/11/2016.
 */
public class EvenementCimetierre extends Evenement {
    private int tmpComptePaquet;
    private Joueur source;

    public EvenementCimetierre(Joueur source) {
        DonneesPartie donneesPartie = Moteur.getInstance().getDonneesPartie();
        this.source = source;
        for (Personnage p : donneesPartie.getPersonnages()) if (p.getNom().equals("condotierre")) this.declarerDeclencheur(p);
    }

    @Override
    public boolean evenementDeclencheParPersonnage(Personnage p, Joueur j, String e, String t) {
        DonneesPartie donneesPartie = Moteur.getInstance().getDonneesPartie();
        if (p.getNom().equals("condotierre") && e.equals("destruction") && t.equals("avant")) {
            tmpComptePaquet = donneesPartie.getPaquet().getNombreCartes();
        }
        else if (p.getNom().equals("condotierre") && e.equals("destruction") && t.equals("apres")) {
            int nbCarteDetruites = tmpComptePaquet - donneesPartie.getPaquet().getNombreCartes();
            if (nbCarteDetruites > source.getOr()) nbCarteDetruites = source.getOr();
            List<Batiment> listeBatimentsDetruits = donneesPartie.getPaquet().piocherDernieres(nbCarteDetruites);
            List<Batiment> listeBatimentsAGarder = source.choisirElements(listeBatimentsDetruits, 0, nbCarteDetruites, "quels batiments souhaitez vous piocher?", false);
            listeBatimentsDetruits.removeAll(listeBatimentsAGarder);
            donneesPartie.getPaquet().replacerALaFin(listeBatimentsDetruits);
            source.setOr(source.getOr() - listeBatimentsAGarder.size());
            source.cartesEnMain().addAll(listeBatimentsAGarder);
            return true;
        }
        return false;
    }

    @Override
    public boolean evenemenDeclenchePartMoteur(Moteur m, String e, String t) {
        return false;
    }
}
