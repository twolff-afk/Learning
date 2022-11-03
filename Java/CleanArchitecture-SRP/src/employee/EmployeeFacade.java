package employee;

public class EmployeeFacade {

    private PayCalculator payCalculator;
    private HourReporter hourReporter;

    public EmployeeFacade() {
        payCalculator = new PayCalculator();
        hourReporter = new HourReporter();
    }

    public int calculatePay() {
        return payCalculator.calculatePay();
    }

    public int reportHours() {
        return hourReporter.reportHours();
    }

}
