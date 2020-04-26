#include "program.h"



Program::Program(QString n, float f, int d){
    this->name = n;
    this->frequency = f;
    this->duration = d;

}

Program::~Program(){

}

QString Program::getName(){
    return name;
}

void Program::displayProgramList(){

}
