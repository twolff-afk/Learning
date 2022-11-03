package interactor;

/**
 * datastructure used by FinancialReportGenerator and FinancialReportController
 */
public class FinancialReportResponseDS {

    private String report;

    public FinancialReportResponseDS() {
        this.report = "empty";
    }

    public FinancialReportResponseDS(String report) {
        this.report = report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
