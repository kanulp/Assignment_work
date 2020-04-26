/********************************************************************************
** Form generated from reading UI file 'activetreatment.ui'
**
** Created by: Qt User Interface Compiler version 5.14.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ACTIVETREATMENT_H
#define UI_ACTIVETREATMENT_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QFrame>
#include <QtWidgets/QLCDNumber>
#include <QtWidgets/QOpenGLWidget>

QT_BEGIN_NAMESPACE

class Ui_ActiveTreatment
{
public:
    QLCDNumber *lcdNumber;
    QOpenGLWidget *openGLWidget;
    QFrame *line;
    QFrame *line_2;

    void setupUi(QDialog *ActiveTreatment)
    {
        if (ActiveTreatment->objectName().isEmpty())
            ActiveTreatment->setObjectName(QString::fromUtf8("ActiveTreatment"));
        ActiveTreatment->resize(480, 364);
        lcdNumber = new QLCDNumber(ActiveTreatment);
        lcdNumber->setObjectName(QString::fromUtf8("lcdNumber"));
        lcdNumber->setGeometry(QRect(190, 10, 101, 51));
        openGLWidget = new QOpenGLWidget(ActiveTreatment);
        openGLWidget->setObjectName(QString::fromUtf8("openGLWidget"));
        openGLWidget->setGeometry(QRect(90, 70, 300, 230));
        line = new QFrame(ActiveTreatment);
        line->setObjectName(QString::fromUtf8("line"));
        line->setGeometry(QRect(0, 290, 481, 20));
        line->setFrameShape(QFrame::HLine);
        line->setFrameShadow(QFrame::Sunken);
        line_2 = new QFrame(ActiveTreatment);
        line_2->setObjectName(QString::fromUtf8("line_2"));
        line_2->setGeometry(QRect(80, 70, 20, 291));
        line_2->setFrameShape(QFrame::VLine);
        line_2->setFrameShadow(QFrame::Sunken);

        retranslateUi(ActiveTreatment);

        QMetaObject::connectSlotsByName(ActiveTreatment);
    } // setupUi

    void retranslateUi(QDialog *ActiveTreatment)
    {
        ActiveTreatment->setWindowTitle(QCoreApplication::translate("ActiveTreatment", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class ActiveTreatment: public Ui_ActiveTreatment {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ACTIVETREATMENT_H
