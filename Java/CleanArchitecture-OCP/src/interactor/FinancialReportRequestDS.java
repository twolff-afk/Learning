package interactor;

/**
 * datastructure used by FinancialReportGenerator and FinancialReportController
 */
public class FinancialReportRequestDS {

    private boolean wannaReport;

    public FinancialReportRequestDS(boolean wannaReport) {
        this.wannaReport = wannaReport;
    }

    public void setWannaReport(boolean wannaReport) {
        this.wannaReport = wannaReport;
    }

    public boolean isWannaReport() {
        return wannaReport;
    }
}
