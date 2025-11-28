abstract class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    abstract void showDetails();
}

class Employee extends Person {
    private int empId;

    Employee(String name, int age, int empId) {
        super(name, age);
        this.empId = empId;
    }

    public int getEmpId() { return empId; }

    void showDetails() {
        System.out.println("Employee: " + getName() + " | Age: " + getAge() + " | ID: " + empId);
    }

    double calculateSalary() {
        return 0;
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, int age, int empId, double salary) {
        super(name, age, empId);
        this.monthlySalary = salary;
    }

    @Override
    double calculateSalary() { return monthlySalary; }
}

class ContractEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    ContractEmployee(String name, int age, int empId, int hours, double rate) {
        super(name, age, empId);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    double calculateSalary() { return hoursWorked * hourlyRate; }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Bhoomika", 21, 101, 50000);
        Employee e2 = new ContractEmployee("Akshay", 23, 102, 160, 300);

        e1.showDetails();
        System.out.println("Salary: " + e1.calculateSalary());
        System.out.println();

        e2.showDetails();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}

