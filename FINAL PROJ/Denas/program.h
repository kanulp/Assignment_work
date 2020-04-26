#ifndef PROGRAM_H
#define PROGRAM_H

#include "QString"

class Program{
public:
    Program(QString, float, int);
    ~Program();
    QString getName();
    void displayProgramList();

private:
    QString name;
    float frequency;
    int duration; //in minutes

};

#endif // PROGRAM_H

