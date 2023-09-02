#include <sqlite3.h>
#include <iostream>
#include <string>
using namespace std;

class TaskManagerDB {
    private:
        sqlite3* db;
        int rc;
    public:
        TaskManagerDB();
        void addTask(string name,string description);
        void removeTask(int id);
        void removeAllTasks();
        void setTaskOk(int id);
        void afficheTasks();
};