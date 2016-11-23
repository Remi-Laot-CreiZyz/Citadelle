/**
 * Created by mstha on 21/11/2016.
 */
public class Application {
    public static void main(String[] args) {
        for (int n = 0; n < 1500; n++){
            Citadelle.Moteur.demarrer("", 1);
            Citadelle.Moteur.clean();
        }
    }
}
