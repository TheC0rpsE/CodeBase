#include "TaskManager.h"
#include <algorithm>

TaskManager::TaskManager() : tasks()
{
}

void TaskManager::addTask(string title,string desc){
    if(title.empty()){
        tasks.push_back(Task());
    }else if(desc.empty()){
        tasks.push_back(Task(title));
    }else{
        tasks.push_back(Task(title,desc));
    }
}

Task TaskManager::getTask(int id) {
    int searchId = 0;
    
    while (searchId != id) {
        if (tasks[searchId].getId() == id) {
            return tasks[searchId];
        } else if (searchId >= tasks.size()) {
            cout << "Id de la Task non attribué" << endl;
            break;
        } else {
            searchId++;
        }
    }
    
    // Aucune tâche correspondante n'a été trouvée, retourne une tâche vide par exemple
    return Task(); 
}

void TaskManager::removeTask(int id) {
    for (int i=0;i<tasks.size();i++) {
        if (tasks[i].getId() == id ) {
            tasks.erase(tasks.begin()+i+1);
        }
    }
}

void TaskManager::removeAllTasks(){
    tasks.clear();
    
}

bool TaskManager::OkTask(int id) {
    for (const Task& task : tasks) {
        if (task.getId() == id && task.isTaskDone()) {
            return true;
        }
    }
    return false;
}

void TaskManager::afficheTasks(){
    for (const Task& task : tasks) {
        cout << "<---><---><---><---><---><---><---><--->" << endl;
        cout << "ID : " <<task.getId() << endl;
        cout << task.getTitle() << " : \n" << endl;
        cout << "Etat : "; 
        if(OkTask(task.getId())){cout << "Fini\n"<<endl;}else{cout << "En cours\n"<<endl;} 
        cout << task.getDescription() << "\n" << endl;
        cout << "<---><---><---><---><---><---><---><--->\n" << endl;
    }
}
