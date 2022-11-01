#include "firstdelegatemain.h"
#include "./ui_firstdelegatemain.h"

firstDelegateMain::firstDelegateMain(QWidget *parent) : QDialog(parent), ui(new Ui::firstDelegateMain)
{
    ui->setupUi(this);

    myDelegate = new delegate(this);
    model = new QStandardItemModel(6,3,this);

    for (int row = 0; row < 6; ++row)
    {
        for (int col = 0; col < 3; ++col)
        {
            QModelIndex index = model->index(row, col, QModelIndex());
            model->setData(index, 22);
        }
    }

    ui->tableView->setModel(model);
    ui->tableView->setItemDelegate(myDelegate);

}

firstDelegateMain::~firstDelegateMain()
{
    delete ui;
}

