/**
 * La classe Task représente une tâche dans le gestionnaire de tâches.
 */
public class Task {
    private String Nom;
    private String Description;
    private Boolean Etat;
    private static int NbTask = 0;

    /**
     * Constructeur par défaut de la classe Task.
     * Initialise une tâche avec un nom par défaut, une description par défaut et un état non terminé.
     */
    public Task() {
        NbTask++;
        this.Nom = "Task#" + NbTask;
        this.Description = "NoNe";
        this.Etat = false;
    }

    /**
     * Constructeur paramétré de la classe Task.
     * @param nom Le nom de la tâche.
     * @param desc La description de la tâche.
     * @param etat L'état de la tâche (terminée ou non).
     */
    public Task(String nom, String desc, boolean etat) {
        NbTask++;
        this.Nom = nom;
        this.Description = desc;
        this.Etat = etat;
    }

    // Getters et Setters

    /**
     * Obtient le nom de la tâche.
     * @return Le nom de la tâche.
     */
    public String getNom() {
        return this.Nom;
    }

    /**
     * Définit le nom de la tâche.
     * @param Nom Le nom à attribuer à la tâche.
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * Obtient la description de la tâche.
     * @return La description de la tâche.
     */
    public String getDescription() {
        return this.Description;
    }

    /**
     * Définit la description de la tâche.
     * @param Description La description à attribuer à la tâche.
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Obtient l'état de la tâche.
     * @return L'état de la tâche (true si terminée, false sinon).
     */
    public Boolean getEtat() {
        return this.Etat;
    }

    /**
     * Définit l'état de la tâche.
     * @param Etat L'état à attribuer à la tâche (true si terminée, false sinon).
     */
    public void setEtat(Boolean Etat) {
        this.Etat = Etat;
    }

    // Méthodes statiques

    /**
     * Définit le nombre total de tâches.
     * @param nbTask Le nombre total de tâches à définir.
     */
    public static void setNbTask(int nbTask) {
        NbTask = nbTask;
    }

    /**
     * Obtient le nombre total de tâches.
     * @return Le nombre total de tâches.
     */
    public static int getNbTask() {
        return NbTask;
    }
}
