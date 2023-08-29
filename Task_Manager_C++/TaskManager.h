#include "Task.h"
#include <vector>

class TaskManager{
    private:
        vector<Task>tasks;
    public:
    TaskManager();
    void addTask(string title,string desc);
    Task getTask(int id);
    void removeTask(int id);
    void removeAllTasks();
    bool OkTask(int id);
    void setTaskOk(int id);
    void afficheTasks();
};