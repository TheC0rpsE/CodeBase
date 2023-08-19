import java.util.HashMap;
import java.util.Scanner;

public class StreakDouble{
    private int serie = 0;
    private boolean estSerieActive = false;
    private static final int NOMBRE_FACES = 6;

    public int lancerDes() {
        int de1 = (int) (Math.random() * NOMBRE_FACES) + 1;
        int de2 = (int) (Math.random() * NOMBRE_FACES) + 1;

        if (de1 == de2 && estSerieActive) {
            serie++;
        } else if (de1 == de2) {
            serie++;
            estSerieActive = true;
            return 1;
        } else {
            int longueurSerieTemp = serie;
            serie = 0;
            estSerieActive = false;
            return longueurSerieTemp;
        }
        return 0;
    }

    public static void main(String[] args) {
        StreakDouble instanceStats = new StreakDouble();
        HashMap<Integer, Integer> compteurSequences = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lancers de dés : ");
        int nombreLancers = scanner.nextInt();

        for (int i = 0; i < nombreLancers; i++) {
            int longueurSequence = instanceStats.lancerDes();
            compteurSequences.put(longueurSequence, compteurSequences.getOrDefault(longueurSequence, 0) + 1);
        }

        // Afficher les statistiques
        for (Integer cle : compteurSequences.keySet()) {
            int occurrences = compteurSequences.get(cle);
            double pourcentage = (occurrences / (double) nombreLancers) * 100;
            System.out.printf("Séquence de %d : %d occurrences | pourcentage : %.5f %%\n", cle, occurrences, pourcentage);
        }
    }
}
