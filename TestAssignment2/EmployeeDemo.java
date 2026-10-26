class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    double calculateSalary() {
        return salary;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return salary + salary * 0.20;
    }
}

class PartTimeEmployee extends Employee {
    int hours;
    double rate;

    PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return hours * rate;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(1, "Arun", 30000);
        Employee e2 = new PartTimeEmployee(2, "Ravi", 80, 200);

        System.out.println(e1.id + " " + e1.name + " " + e1.calculateSalary());
        System.out.println(e2.id + " " + e2.name + " " + e2.calculateSalary());
    }
}
