package printPresenter;

public class PrintViewModelDS {

    private String printReport;

    public PrintViewModelDS(String printReport) {
        this.printReport = printReport;
    }

    public void setPrintReport(String printReport) {
        this.printReport = printReport;
    }

    public String getPrintReport() {
        return printReport;
    }

}
