package employee;

public class HourReporter {

    private int overallWorkingTime;

    public HourReporter() {
        this.overallWorkingTime = 0;
    }

    public int reportHours() {
        overallWorkingTime = (EmployeeData.getHours() + EmployeeData.getAfterHours()) - 10;
        return overallWorkingTime;
    }
}
