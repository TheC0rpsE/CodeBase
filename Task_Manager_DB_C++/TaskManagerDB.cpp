#include "TaskManagerDB.h"

TaskManagerDB::TaskManagerDB(){
    rc = sqlite3_open("DB_TASK",&db);
     if (rc) {
        cerr << "Erreur lors de l'ouverture de la base de données : " << sqlite3_errmsg(db) << endl;
    } else {
        cout << "Base de données ouverte avec succès !" << endl;
    }
    const char* requete_create_table = "CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50) NOT NULL,description TEXT DEFAULT 'NoNe',TaskDo BOOLEAN DEFAULT false)";
     rc = sqlite3_exec(db, requete_create_table, nullptr, nullptr, nullptr);
     if (rc!=SQLITE_OK) {
        cerr << "Erreur lors de la creation du tableau  : " << sqlite3_errmsg(db) << endl;
    } else {
        cout << "Creation du tableau tasks avec succès !" << endl;
    }
}

void TaskManagerDB::addTask(string name,string description){
    const char* requete_add_task = "INSERT INTO tasks(name,description)VALUES(?,?)";
     // Préparer la requête
    sqlite3_stmt* stmt;
    int rc = sqlite3_prepare_v2(db, requete_add_task, -1, &stmt, nullptr);

    if (rc != SQLITE_OK) {
        cerr << "Erreur lors de la préparation de la requête : " << sqlite3_errmsg(db) << endl;
        return;
    }

    // Lier les paramètres de la requête aux valeurs réelles
    sqlite3_bind_text(stmt, 1, name.c_str(), -1, SQLITE_STATIC);
    sqlite3_bind_text(stmt, 2, description.c_str(), -1, SQLITE_STATIC);

    // Exécuter la requête
    rc = sqlite3_step(stmt);

    if (rc != SQLITE_DONE) {
      cerr << "Erreur lors de l'exécution de la requête : " << sqlite3_errmsg(db) << endl;
    } else {
        cout << "Tâche ajoutée avec succès !" << endl;
    }

    // Finaliser la requête et la libérer
    sqlite3_finalize(stmt);

}

void TaskManagerDB::removeTask(int id){
    const char* requete_delete_task = "DELETE FROM tasks WHERE id=?";
    // Préparer la requête
    sqlite3_stmt* stmt;
    rc = sqlite3_prepare_v2(db, requete_delete_task, -1, &stmt, nullptr);

    if (rc != SQLITE_OK) {
        cerr << "Erreur lors de la préparation de la requête : " << sqlite3_errmsg(db) << endl;
        return;
    }
    // Conversion de l'entier en une chaîne de caractères
    string chaine = std::to_string(id);
    // Conversion de la chaîne en un pointeur const char*
    const char* pointeurId = chaine.c_str();
    // Lier les paramètres de la requête aux valeurs réelles
    sqlite3_bind_text(stmt, 1, pointeurId, -1, SQLITE_STATIC);

    // Exécuter la requête
    rc = sqlite3_step(stmt);

    if (rc != SQLITE_DONE) {
      cerr << "Erreur lors de l'exécution de la requête : " << sqlite3_errmsg(db) << endl;
    } else {
        cout << "Tâche ajoutée avec succès !" << endl;
    }

    // Finaliser la requête et la libérer
    sqlite3_finalize(stmt);
}

void TaskManagerDB::removeAllTasks(){
    const char* requete_deleteall_task = "DELETE FROM tasks";
    rc = sqlite3_exec(db,requete_deleteall_task,nullptr,nullptr,nullptr);

     if (rc != SQLITE_OK) {
        cerr << "Erreur lors de l'execution de la requête : " << sqlite3_errmsg(db) << endl;
        return;
    }

    const char* requete_reset_autoincrement = "DELETE FROM sqlite_sequence WHERE name='tasks'";
    rc = sqlite3_exec(db, requete_reset_autoincrement, nullptr, nullptr, nullptr);

    if (rc != SQLITE_OK) {
        cerr << "Erreur lors de la réinitialisation de l'auto-incrémentation : " << sqlite3_errmsg(db) << endl;
        return;
    }

    cout << "Toutes les tâches ont été supprimées avec succès !" << endl;

}

void TaskManagerDB::setTaskOk(int id){
     const char* requete_settaskdo_true = "UPDATE tasks SET TaskDo=true WHERE id=?";
     sqlite3_stmt* stmt;
     rc = sqlite3_prepare_v2(db, requete_settaskdo_true, -1, &stmt, nullptr);

    if (rc != SQLITE_OK) {
        cerr << "Erreur lors de la préparation de la requête : " << sqlite3_errmsg(db) << endl;
        return;
    }
    // Conversion de l'entier en une chaîne de caractères
    string chaine = std::to_string(id);
    // Conversion de la chaîne en un pointeur const char*
    const char* pointeurId = chaine.c_str();
    // Lier les paramètres de la requête aux valeurs réelles
    sqlite3_bind_text(stmt, 1, pointeurId, -1, SQLITE_STATIC);

    // Exécuter la requête
    rc = sqlite3_step(stmt);

    if (rc != SQLITE_DONE) {
      cerr << "Erreur lors de l'exécution de la requête : " << sqlite3_errmsg(db) << endl;
    } else {
        cout << "Tâche ajoutée avec succès !" << endl;
    }

    // Finaliser la requête et la libérer
    sqlite3_finalize(stmt);
}

void TaskManagerDB::afficheTasks(){
    // Préparez la requête pour sélectionner toutes les tâches
    const char* requete_select_tasks = "SELECT id, name, description, TaskDo FROM tasks";

    // Préparez une instruction SQL
    sqlite3_stmt* stmt;
    int rc = sqlite3_prepare_v2(db, requete_select_tasks, -1, &stmt, nullptr);

    if (rc != SQLITE_OK) {
        cerr << "Erreur lors de la préparation de la requête : " << sqlite3_errmsg(db) << endl;
        return;
    }

    // Exécutez la requête et parcourez les résultats
    while (sqlite3_step(stmt) == SQLITE_ROW) {
        int id = sqlite3_column_int(stmt, 0);
        const char* name = reinterpret_cast<const char*>(sqlite3_column_text(stmt, 1));
        const char* description = reinterpret_cast<const char*>(sqlite3_column_text(stmt, 2));
        int taskDo = sqlite3_column_int(stmt, 3);

        cout << "////////////////////////////////////////" << endl;       
        cout << "ID : " << id << endl;
        cout << name << "\n" << endl;
        cout << "Etat : ";
        if (taskDo) {
            cout << "Fini\n" << endl;
        } else {
            cout << "En cours\n" << endl;
        }
        cout << description << "\n" << endl;
        cout << "////////////////////////////////////////\n" << endl;
    }

    // Finalisez l'instruction
    sqlite3_finalize(stmt);
}