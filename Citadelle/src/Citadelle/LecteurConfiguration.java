package Citadelle;

import Citadelle.Cartes.Batiments.Batiment;
import Citadelle.Cartes.Batiments.BatimentSimple;
import Citadelle.Cartes.Batiments.Merveilles.V1.*;
import Citadelle.Cartes.Batiments.Merveilles.V2.*;
import Citadelle.Cartes.Batiments.Merveilles.V3.*;
import Citadelle.Cartes.Personnages.Personnage;
import Citadelle.Cartes.Personnages.V1.*;
import Citadelle.Cartes.Personnages.V2.*;
import Citadelle.Joueurs.Joueur;
import Citadelle.Joueurs.JoueurConsole;
import Citadelle.Joueurs.RandomIA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstha on 23/11/2016.
 */
public class LecteurConfiguration {
    private String config;

    public LecteurConfiguration(String config) {
        this.config = config;
    }

    public List<Joueur> genererListeJoueurs() {
        // TODO extraire la liste des joueurs d'un fichier de configuration
        List<Joueur> liste = new ArrayList<>();
        //liste.add(new JoueurConsole("Jean"));
        //liste.add(new JoueurConsole("Camille"));
        liste.add(new RandomIA("IA 1"));
        liste.add(new RandomIA("IA 2"));
        return liste;
    }

    public List<Personnage> genererListePersonnages() {
        // TODO extraire la liste du fichier de config
        List<Personnage> liste = new ArrayList<>();
        liste.add(new Assassin());
        liste.add(new Architecte());
        liste.add(new Condotierre());
        liste.add(new Eveque());
        liste.add(new Magicien());
        liste.add(new Marchand());
        liste.add(new Roi());
        liste.add(new Voleur());
        return liste;
    }

    public List<Batiment> genererListeBatiments() {
        boolean merveillesV1 = true;
        boolean merveillesV2 = false;
        boolean merveillesV3 = false;

        // TODO extraire merveillesV1, merveillesV2 et merveillesV3 d'un fichier de config

        List<Batiment> list = new ArrayList<Batiment>();

        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("temple", 1, "bleu", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("église", 2, "bleu", ""));
        for (int n = 4; n > 0; n--) list.add(new BatimentSimple("monastère", 3, "bleu", ""));
        for (int n = 2; n > 0; n--) list.add(new BatimentSimple("cathédrale", 1, "bleu", ""));

        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("tour de garde", 1, "rouge", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("prison", 2, "rouge", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("baraquement", 3, "rouge", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("forteresse", 5, "rouge", ""));

        for (int n = 5; n > 0; n--) list.add(new BatimentSimple("taverne", 1, "vert", ""));
        for (int n = 4; n > 0; n--) list.add(new BatimentSimple("étale", 2, "vert", ""));
        for (int n = 4; n > 0; n--) list.add(new BatimentSimple("marché", 2, "vert", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("comptoir", 3, "vert", ""));
        for (int n = 3; n > 0; n--) list.add(new BatimentSimple("port", 4, "vert", ""));
        for (int n = 2; n > 0; n--) list.add(new BatimentSimple("hôtel de ville", 5, "vert", ""));

        for (int n = 5; n > 0; n--) list.add(new BatimentSimple("manoir", 3, "jaune", ""));
        for (int n = 2; n > 0; n--) list.add(new BatimentSimple("palais", 5, "jaune", ""));
        for (int n = 5; n > 0; n--) list.add(new BatimentSimple("chateau", 4, "jaune", ""));

        if (merveillesV1) {
            list.add(new Bibliotheque());
            list.add(new Cimetiere());
            list.add(new CourDesMiracles());
            list.add(new Donjon()); // x2
            list.add(new Donjon());
            list.add(new Dracofort());
            list.add(new EcoleDeMagie());
            list.add(new Manufacture());
            list.add(new Observatoire());
            list.add(new Universite());
            list.add(new GrandeMuraille());
        }

        if (merveillesV2) {
            list.add(new Carriere());
            list.add(new FontaineAuxSouhaits());
            list.add(new TresorImperial());
        }

        if (merveillesV3) {
            list.add(new Beffroi());
            list.add(new Fabrique());
            list.add(new Hopital());
            list.add(new Hospice());
            list.add(new Musee());
            list.add(new Parc());
            list.add(new Poudriere());
            list.add(new SalleDeBal());
            list.add(new SalleDesCartes());
            list.add(new SalleDuTrone());
        }

        return list;
    }

    public int extraireOrInitialBanque() {
        return 50;
    }
    public int extraireDureeInitiale() {
        return 8; // TODO extraire fichier config...
    }
    public int extraireOr() {
        return 2; // TODO extraire du fichier de config
    }
    public int extraireMaxNbCartesTirees() {
        return 2; // TODO extraire du fichier de config
    }
    public int extraireMaxNbCartesGardees() {
        return 1; // TODO extraire du fichier de config
    }
    public int extraireMontantRevenu() {
        return 2; // TODO extraire du fichier de config
    }
    public int extraireMaxNbConstrParTour() {
        return 1; // TODO extraire du fichier de config
    }
    public int extraireMaxNbConstrIdentique() {
        return 1; // TODO extraire du fichier de config
    }
    public int extraireNbCartesInitial() {
        return 4; // TODO extraire du fichier de config
    }
}
