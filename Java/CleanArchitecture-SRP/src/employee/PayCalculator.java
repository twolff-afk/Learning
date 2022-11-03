package employee;

public class PayCalculator {

    private int pay;
    private int pricePerHour;

    public PayCalculator() {
        pay = 0;
        pricePerHour = 20;
    }

    public int calculatePay() {
        this.pay = (EmployeeData.getHours() * pricePerHour) + 10;
        return this.pay;

    }

}
