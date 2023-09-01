import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager T = new TaskManager();

        try {
            while (true) {
                System.out.println("-----------------------------------");
                System.out.println("| Menu:                           |");
                System.out.println("| 1. Ajouter une tâche            |");
                System.out.println("| 2. Marquer une tâche finie      |");
                System.out.println("| 3. Supprimer une tâche          |");
                System.out.println("| 4. Afficher la liste des tâches |");
                System.out.println("| 5. Quitter                      |");
                System.out.println("-----------------------------------");

                int choix = scanner.nextInt();
                scanner.nextLine(); // Consomme le saut de ligne

                switch (choix) {
                    case 1:
                        System.out.println("Entrer le nom de la tâche :");
                        String n = scanner.nextLine();
                        System.out.println("Entrer la description de la tâche :");
                        String d = scanner.nextLine();
                        System.out.println("Est-ce une tâche déjà effectuée ? Entrer 'oui' ou 'non' :");
                        String e = scanner.nextLine();
                        if (e.equals("oui")) {
                            T.addTask(n, d, true);
                        } else {
                            T.addTask(n, d, false);
                        }
                        System.out.println("Tâche ajoutée !");
                        break;
                    case 2:
                        System.out.println("Quelle tâche souhaitez-vous marquer comme terminée (entrez le numéro) ?");
                        int i = scanner.nextInt();
                        T.OkTask(i - 1);
                        System.out.println("Tâche marquée comme terminée !");
                        break;
                    case 3:
                        System.out.println("Quelle tâche souhaitez-vous supprimer (entrez le numéro) ?");
                        int y = scanner.nextInt();
                        T.removeTask(y - 1);
                        System.out.println("Tâche supprimée !");
                        break;
                    case 4:
                        T.AfficheTask();
                        break;
                    case 5:
                        System.out.println("Au revoir !");
                        return; // Sortir de la boucle
                    default:
                        System.out.println("Choix invalide");
                }
            }
        } finally {
            scanner.close(); // Fermer le scanner proprement
        }
    }
}
