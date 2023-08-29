#include <iostream>
#include <string>
#include "TaskManager.h"

int main() {
    TaskManager T;

    while (true) {
        std::cout << "-----------------------------------" << std::endl;
        std::cout << "| Menu:                           |" << std::endl;
        std::cout << "| 1. Ajouter une tache            |" << std::endl;
        std::cout << "| 2. Marquer une tache finie      |" << std::endl;
        std::cout << "| 3. Supprimer une tache          |" << std::endl;
        std::cout << "| 4. Afficher la liste des taches |" << std::endl;
        std::cout << "| 5. supprimer toutes les taches  |" << std::endl;
        std::cout << "| 6. Quitter                      |" << std::endl;
        std::cout << "-----------------------------------" << std::endl;

        int choix;
        std::cin >> choix;
        std::cin.ignore(); // Consomme le saut de ligne

        switch (choix) {
            case 1: {
                std::cout << "Entrer le nom de la tâche :" << std::endl;
                std::string n;
                std::getline(std::cin, n);
                std::cout << "Entrer la description de la tâche :" << std::endl;
                std::string d;
                std::getline(std::cin, d);
                T.addTask(n, d);
                std::cout << "Tâche ajoutée !" << std::endl;
                break;
            }
            case 2: {
                std::cout << "Quelle tâche souhaitez-vous marquer comme terminée (entrez le numéro) ?" << std::endl;
                int i;
                std::cin >> i;
                T.setTaskOk(i);
                std::cout << "Tâche marquée comme terminée !" << std::endl;
                break;
            }
            case 3: {
                std::cout << "Quelle tâche souhaitez-vous supprimer (entrez le numéro) ?" << std::endl;
                int y;
                std::cin >> y;
                T.removeTask(y);
                std::cout << "Tâche supprimée !" << std::endl;
                break;
            }
            case 4:
                T.afficheTasks();
                break;
            case 5:
                T.removeAllTasks();
                std::cout << "Toutes les tâches supprimées" << std::endl;
                break;
            case 6:
                std::cout << "Au revoir !" << std::endl;
                return 0; // Sortir du programme
            default:
                std::cout << "Choix invalide" << std::endl;
                break;
        }
    }

    return 0;
}
