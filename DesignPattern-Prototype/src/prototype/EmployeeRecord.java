package prototype;

public class EmployeeRecord implements Prototype {

    private int id;
    private String name;
    private String designation;
    private double salary;
    public EmployeeRecord() {
        System.out.println(" EmployeeRecord of Oracle Corperation ");
        System.out.println(" ------------------------------------ ");
        System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary");
    }

    public EmployeeRecord(int id, String name, String designation, double salary) {

        this(); // Constructor of this class is called
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;

    }

    public void showRecord(){
        System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t");
    }

    @Override
    public Prototype getClone() {
        return new EmployeeRecord(id, name, designation, salary);
    }
}
