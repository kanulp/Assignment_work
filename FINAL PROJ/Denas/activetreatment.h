#ifndef ACTIVETREATMENT_H
#define ACTIVETREATMENT_H

#include <QDialog>

namespace Ui {
class ActiveTreatment;
}

class ActiveTreatment : public QDialog
{
    Q_OBJECT

public:
    explicit ActiveTreatment(QWidget *parent = nullptr);
    ~ActiveTreatment();

private:
    Ui::ActiveTreatment *ui;
};

#endif // ACTIVETREATMENT_H
