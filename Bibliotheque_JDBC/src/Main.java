import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Afficher un livre par ID");
            System.out.println("3. Afficher tous les livres");
            System.out.println("4. Mettre à jour un livre");
            System.out.println("5. Supprimer un livre");
            System.out.println("6. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Titre: ");
                    String titre = scanner.nextLine();
                    System.out.print("Auteur: ");
                    String auteur = scanner.nextLine();
                    System.out.print("Année de publication: ");
                    int annee = scanner.nextInt();
                    System.out.print("Disponible (true/false): ");
                    boolean disponible = scanner.nextBoolean();
                    Livre livreAjouter = new Livre(-1,titre,auteur,annee,disponible);
                    bibliotheque.ajouterLivre(livreAjouter);
                    break;

                case 2:
                    System.out.print("ID du livre à afficher: ");
                    int idAffiche = scanner.nextInt();
                    Livre livre = bibliotheque.getLivreById(idAffiche);
                    if (livre != null) {
                        livre.afficheInfoLivre();
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;

                case 3:
                    List<Livre> livres = bibliotheque.getTousLesLivres();
                    for (Livre l : livres) {
                        System.out.println();
                        l.afficheInfoLivre();
                    }
                    break;

                case 4:
                    System.out.print("ID du livre à mettre à jour: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Nouveau titre: ");
                    String nouveauTitre = scanner.nextLine();
                    System.out.print("Nouvel auteur: ");
                    String nouvelAuteur = scanner.nextLine();
                    System.out.print("Nouvelle année de publication: ");
                    int nouvelleAnnee = scanner.nextInt();
                    System.out.print("Disponible (true/false): ");
                    boolean nouvelleDisponibilite = scanner.nextBoolean();
                    Livre livreModif = new Livre(idUpdate, nouveauTitre, nouvelAuteur, nouvelleAnnee, nouvelleDisponibilite);
                    bibliotheque.modifierLivre(livreModif);
                    break;

                case 5:
                    System.out.print("ID du livre à supprimer: ");
                    int idSupprime = scanner.nextInt();
                    bibliotheque.supprimerLivre(idSupprime);
                    break;

                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
}
