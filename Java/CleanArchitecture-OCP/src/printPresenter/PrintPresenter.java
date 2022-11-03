package printPresenter;

import controller.FinancialReportPresenter;
import interactor.FinancialReportResponseDS;
import pdfView.PDFView;

public class PrintPresenter implements FinancialReportPresenter {
    @Override
    public void presentReport(FinancialReportResponseDS response) {

        PrintViewModelDS printView = new PrintViewModelDS(response.getReport());
        PrintView printView1 = new PDFView();
        printView1.printPrintView(printView);


    }
}
