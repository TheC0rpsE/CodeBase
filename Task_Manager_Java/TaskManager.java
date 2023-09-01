import java.util.ArrayList;
import java.util.List;

/**
 * La classe TaskManager gère une liste de tâches.
 */
public class TaskManager {
    private List<Task> tasks;

    /**
     * Constructeur de la classe TaskManager.
     * Initialise la liste de tâches.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Ajoute une nouvelle tâche à la liste de tâches.
     * Si le nom est vide, une tâche par défaut est ajoutée.
     * @param nom Le nom de la tâche.
     * @param desc La description de la tâche.
     * @param etat L'état de la tâche (terminée ou non).
     */
    public void addTask(String nom, String desc, boolean etat) {
        if (!nom.equals("")) {
            tasks.add(new Task(nom, desc, etat));
        } else {
            tasks.add(new Task());
        }
    }

    /**
     * Supprime une tâche de la liste de tâches.
     * Réduit également le nombre total de tâches.
     * @param index L'indice de la tâche à supprimer.
     */
    public void removeTask(int index) {
        tasks.remove(index);
        Task.setNbTask(Task.getNbTask() - 1);
    }

    /**
     * Marque une tâche comme terminée.
     * @param index L'indice de la tâche à marquer comme terminée.
     */
    public void OkTask(int index) {
        tasks.get(index).setEtat(true);
    }

    /**
     * Affiche les détails de toutes les tâches dans la liste.
     */
    public void AfficheTask() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("<---><---><---><---><---><---><---><--->");
            System.out.println(tasks.get(i).getNom() + " :\n");
            System.out.println("Etat : " + (tasks.get(i).getEtat() ? "Fini" : "En cours") + "\n");
            System.out.println(tasks.get(i).getDescription() + "\n");
            System.out.println("<---><---><---><---><---><---><---><--->\n");
        }
    }
}
