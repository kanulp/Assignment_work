#ifndef MAINWINDOW_H
#define MAINWINDOW_H
#include "program.h"
#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();
    int mainMenu(int);
    void deviceOn();
    void onTimeOut();
    void loadMainMenu();

private slots:

    void on_power_clicked();

    void on_up_clicked();

    void on_down_clicked();

    void on_pushButton_clicked();

    void on_mainMenu_clicked();

    void on_right_clicked();

    void on_left_clicked();

private:
    bool on;
    int powerLev;
    int mode;
    int segueLevel;
    Ui::MainWindow *ui;
    QTimer*timer;
    QList <Program*> progVector;
};
#endif // MAINWINDOW_H
