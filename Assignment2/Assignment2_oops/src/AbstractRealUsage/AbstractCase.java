package AbstractRealUsage;

abstract class Employee {
    String employeeName;
    int empId;

    Employee(String employeeName, int empId) {
        this.employeeName = employeeName;
        this.empId = empId;
    }

    abstract void calculateSalary();

    void employeeDetails() {
        System.out.println("\nEmployee details:");
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + empId);
    }
}

class FullTimeEmployee extends Employee {
    int basicSalary;
    int pfAmount;

    FullTimeEmployee(String employeeName, int empId, int basicSalary, int pfAmount) {
        super(employeeName, empId);
        this.basicSalary = basicSalary;
        this.pfAmount = pfAmount;
    }

    @Override
    void calculateSalary() {
        int netSalary = basicSalary - pfAmount;
        System.out.println("Full-time salary: " + netSalary);
    }
}

class PartTimeEmployee extends Employee {
    int hourlyWage;
    int hoursWorked;

    PartTimeEmployee(String employeeName, int empId, int hourlyWage, int hoursWorked) {
        super(employeeName, empId);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    void calculateSalary() {
        int netSalary = hourlyWage * hoursWorked;
        System.out.println("Part-time salary: " + netSalary);
    }
}

public class AbstractCase {
    public static void main(String[] args) {
        FullTimeEmployee ref = new FullTimeEmployee("Dhivyaa", 101, 50000, 5000);
        ref.employeeDetails();
        ref.calculateSalary();

        PartTimeEmployee ref1 = new PartTimeEmployee("Arun", 102, 500, 40);
        ref1.employeeDetails();
        ref1.calculateSalary();
    }
}
