import java.util.ArrayList;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Full-time employee subclass
class FullTimeEmployee extends Employee {
    private double fixedSalary;

    // Constructor
    public FullTimeEmployee(int employeeId, String name, double fixedSalary) {
        super(employeeId, name, fixedSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary;
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    // Constructor
    public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
        super(employeeId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Interface for Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Creating employees
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 25);

        // Adding employees to list
        employees.add(emp1);
        employees.add(emp2);

        // Displaying employee details using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}
