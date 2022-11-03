package main;

import prototype.EmployeeRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
Example for the prototype design pattern
It is mainly used when creating new objects require a lot of cost
for example at a bank: when creating my first account I have to provide a lot of information
when I want to open a second bank account I do not want to insert all my personal information again.
Here the prototype design pattern can simply create a clone of already existing information.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Employee Id: ");
        int id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("\n");

        System.out.println("Enter Employee Name: ");
        String name = bufferedReader.readLine();
        System.out.println("\n");

        System.out.println("Enter Employee Designation: ");
        String designation = bufferedReader.readLine();
        System.out.println("\n");

        System.out.println("Enter Employee Salary: ");
        double salary = Double.parseDouble(bufferedReader.readLine());
        System.out.println("\n");

        EmployeeRecord employee = new EmployeeRecord(id, name, designation, salary);
        employee.showRecord();
        System.out.println("\n");

        EmployeeRecord employeeClone = (EmployeeRecord) employee.getClone();
        employeeClone.showRecord();


    }

}
