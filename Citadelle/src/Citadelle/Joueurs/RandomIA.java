package Citadelle.Joueurs;

import Citadelle.Moteur;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mstha on 23/11/2016.
 */
public class RandomIA extends Joueur {
    private Random rand;

    public RandomIA(String nom) {
        super(nom);
        rand = new Random();
    }

    @Override
    public <T> T choisirElement(List<T> liste, String description, boolean obligatoire) {
        if (liste.size() == 0) return null;
        int choix = rand.nextInt(liste.size());
        return liste.get(choix);
    }

    @Override
    public <T> List<T> choisirElements(List<T> liste, int minChoix, int maxChoix, String description, boolean obligatoire) {
        if (liste.size() == 0) return null;
        Set<T> setChoix = new HashSet<>();
        if (minChoix > liste.size()) minChoix = liste.size();
        if (maxChoix > liste.size()) maxChoix = liste.size();
        boolean pass = false;
        while ((!pass || setChoix.size() < minChoix) && setChoix.size() < maxChoix) {
            if (Moteur.getInstance().verbose > 3) System.out.println("     nb choix faits: " + setChoix.size() + "/[" + minChoix + ".." + maxChoix + "] (taille liste: " + liste.size() + ")");
            setChoix.add(liste.get(rand.nextInt(liste.size())));
            if (setChoix.size() >= minChoix && rand.nextInt(2) == 0) {
                if (Moteur.getInstance().verbose > 3) System.out.println("     passe = true");
                pass = true; // 1 chance sur 2 de passer
            }
        }
        return setChoix.stream().collect(Collectors.toList());
    }
}
