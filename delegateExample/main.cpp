#include "firstdelegatemain.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    firstDelegateMain w;
    w.show();
    return a.exec();
}
