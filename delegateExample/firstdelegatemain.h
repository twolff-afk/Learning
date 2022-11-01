#ifndef FIRSTDELEGATEMAIN_H
#define FIRSTDELEGATEMAIN_H

#include "delegate.h"

#include <QDialog>
#include <QtCore>
#include <QtGui>

QT_BEGIN_NAMESPACE
namespace Ui { class firstDelegateMain; }
QT_END_NAMESPACE

class firstDelegateMain : public QDialog
{
    Q_OBJECT

public:
    firstDelegateMain(QWidget *parent = nullptr);
    ~firstDelegateMain();

private:
    Ui::firstDelegateMain *ui;
    QStandardItemModel *model;
    delegate *myDelegate;
};
#endif // FIRSTDELEGATEMAIN_H
