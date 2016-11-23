package Citadelle.Joueurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by mstha on 17/11/2016.
 */
public class JoueurConsole extends Joueur {
    private Scanner console;

    /**
     * Constructeur unique d'un joueur interagissant via la console
     * @param nom le nom du joueur
     */
    public JoueurConsole(String nom) {
        super(nom);
        this.console = new Scanner(System.in);
    }

    private int attendreIntJoueur() {
        int n = -2;
        while (console.hasNext()){
            if (console.hasNextInt()){
                n = console.nextInt();
                break;
            } else {
                console.next(); // Just discard this, not interested...
            }
        }
        return n;
    }

    @Override
    public <T> T choisirElement(List<T> liste, String description, boolean obligatoire) {
        if (liste.size() > 0) {
            int limiteChoixMin = (obligatoire)? -1 : -2;
            int limiteChoixMax = liste.size();
            int choix = limiteChoixMin;
            while( choix <= limiteChoixMin || choix >= limiteChoixMax) {
                System.out.println(this.toString());
                System.out.println(">Veuillez choisir " + description);
                if (!obligatoire) System.out.println(" . Choix (-1): passer");
                for (int n = 0; n < limiteChoixMax; n++) {
                    System.out.println(" . Choix (" + n + "): " + liste.get(n).toString());
                }
                choix = attendreIntJoueur();
            }
            return (choix == -1) ? null : liste.get(choix);
        }
        return null;
    }

    @Override
    public <T> List<T> choisirElements(List<T> liste, int minChoix, int maxChoix, String description, boolean obligatoire) {
        if (liste.size() > 0) {
            List<Integer> listeChoix = new ArrayList<>();
            boolean passe = false;
            while (!passe && listeChoix.size() < maxChoix) {
                int limiteChoixMin = (obligatoire)? -1 : -2;
                int limiteChoixMax = liste.size();
                Integer choix = limiteChoixMin;
                while( choix <= limiteChoixMin || choix >= limiteChoixMax) {
                    System.out.println(this.toString());
                    System.out.println(">Veuillez choisir " + description);
                    if (!obligatoire || listeChoix.size() >= minChoix) System.out.println(" . Choix (-1): passer");
                    for (int n = 0; n < limiteChoixMax; n++) {
                        String tmp = (listeChoix.contains(n))? " [o] " : " [ ] ";
                        System.out.println(tmp + "Choix (" + n + "): " + liste.get(n).toString());
                    }
                    choix = attendreIntJoueur();
                    if (listeChoix.contains(choix)) while (listeChoix.contains(choix)) listeChoix.remove(choix);
                    else listeChoix.add(choix);
                }
            }
            return listeChoix.stream().map(i -> liste.get(i)).collect(Collectors.toList());
        }
        return null;
    }
}
