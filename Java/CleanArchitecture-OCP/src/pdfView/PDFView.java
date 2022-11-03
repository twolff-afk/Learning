package pdfView;

import printPresenter.PrintView;
import printPresenter.PrintViewModelDS;

public class PDFView implements PrintView {

    @Override
    public void printPrintView(PrintViewModelDS printView) {

        System.out.println("Printed report, " + printView.getPrintReport());

    }
}
