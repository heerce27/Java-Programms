abstract class Employee {
    String name;
    int id;
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;
    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }
    @Override
    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    double hours, rate;
    PartTime(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;
    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }
    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
            new FullTime("Heer", 101, 50000),
            new Intern("Diya", 102, 15000),
            new PartTime("Khushi", 103, 80, 300)
        };
        double total = 0;
        for (Employee e : employees) {
            double salary = e.monthlySalary();
            total = total + salary;
            System.out.printf( "Employee: %s | ID: %d | Salary: %.2f%n",e.name, e.id, salary);
            if (e instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }
            System.out.println();
        }
        System.out.printf("Total monthly payroll: %.2f%n", total);
    }
}