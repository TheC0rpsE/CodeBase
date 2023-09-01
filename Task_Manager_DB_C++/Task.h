#include <iostream>
#include <string>

using namespace std;

class Task{
    private:
        int id;
        string title;
        string description;
        bool TaskDone;
        

    public:
    static int globalCounter;
        Task();
        Task(string title);
        Task(string title,string description);
        int getId() const;
        void setId(int newId);
        string getTitle() const;
        void setTitle(string newTitle);
        string getDescription() const;
        void setDescription(string newDescription);
        bool isTaskDone() const;
        void setTaskDone(bool newTaskDone);
};

