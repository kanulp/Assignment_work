#include "activetreatment.h"
#include "ui_activetreatment.h"

ActiveTreatment::ActiveTreatment(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::ActiveTreatment)
{
    ui->setupUi(this);
}

ActiveTreatment::~ActiveTreatment()
{
    delete ui;
}
