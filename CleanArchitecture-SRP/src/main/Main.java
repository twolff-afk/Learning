package main;

import employee.EmployeeFacade;

public class Main {

    /**
     * Purpose of this project was to understand the SRP.
     * The idea is to separate different concerns. Here
     * you can modify easily the classes PayCalculator and
     * HourReporter and EmployeeSaver whenever the requirements change.
     * E.g. if the requirements change of how to calculate the salary, then
     * you only have to modify the class PayCalculator.
     * The requirements change, because one of the user wants to.
     * The user is part of the Use-Case Analysis
     * @param args
     */
    public static void main(String[] args) {

        EmployeeFacade employee1 = new EmployeeFacade();

        System.out.println(employee1.calculatePay());
        System.out.println(employee1.reportHours());

    }
}
