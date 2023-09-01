#include "Task.h"
int Task::globalCounter = 0;

Task::Task() : id(Task::globalCounter + 1), title("Task#" + to_string(Task::globalCounter+1)), description("NoNe"), TaskDone(false)
{
    ++globalCounter;
}

Task::Task(string title) : id(Task::globalCounter + 1), title(title), description("NoNe"), TaskDone(false)
{
    ++globalCounter;
}

Task::Task(string title, string description) : id(Task::globalCounter + 1), title(title), description(description), TaskDone(false)
{
    ++globalCounter;
}

int Task::getId() const
{
    return id;
}

void Task::setId(int newId)
{
    id=newId;
}

string Task::getTitle()const{
    return title;
}

void Task::setTitle(string newTitle){
    title=newTitle;
}

string Task::getDescription()const{
    return description;
}

void Task::setDescription(string newDescription){
    description=newDescription;
}

bool Task::isTaskDone()const{
    return TaskDone;
}

void Task::setTaskDone(bool newTaskDone){
    TaskDone=newTaskDone;
}






