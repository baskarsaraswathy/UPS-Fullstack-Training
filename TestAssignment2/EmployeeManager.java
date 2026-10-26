import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name, dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + dept + " " + salary;
    }
}

public class EmployeeManager {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        HashSet<Integer> ids = new HashSet<>();

        // Load saved employee records
        File f = new File("employees.txt");
        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String a[] = line.split(",");
                Employee e = new Employee(Integer.parseInt(a[0]), a[1],
                        a[2], Double.parseDouble(a[3]));
                if (ids.add(e.id)) {
                    list.add(e);
                    map.put(e.id, e);
                }
            }
            br.close();
        }

        while (true) {
            System.out.println("1.Add 2.Search 3.Update 4.Delete 5.Display 6.Save and Exit");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 1) {
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(sc.nextLine());

                if (ids.contains(id)) {
                    System.out.println("ID already exists");
                    continue;
                }

                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter department: ");
                String dept = sc.nextLine();
                System.out.print("Enter salary: ");
                double salary = Double.parseDouble(sc.nextLine());

                if (name.trim().isEmpty() || dept.trim().isEmpty() || salary < 0) {
                    System.out.println("Invalid data");
                    continue;
                }

                Employee e = new Employee(id, name, dept, salary);
                list.add(e);
                map.put(id, e);
                ids.add(id);
                System.out.println("Employee added");

            } else if (ch == 2) {
                System.out.print("Enter ID: ");
                Employee e = map.get(Integer.parseInt(sc.nextLine()));
                System.out.println(e == null ? "Not found" : e);

            } else if (ch == 3) {
                System.out.print("Enter ID: ");
                Employee e = map.get(Integer.parseInt(sc.nextLine()));

                if (e != null) {
                    System.out.print("Enter new salary: ");
                    double salary = Double.parseDouble(sc.nextLine());
                    if (salary >= 0) {
                        e.salary = salary;
                        System.out.println("Salary updated");
                    } else {
                        System.out.println("Invalid salary");
                    }
                } else {
                    System.out.println("Not found");
                }

            } else if (ch == 4) {
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(sc.nextLine());
                Employee e = map.remove(id);

                if (e != null) {
                    list.remove(e);
                    ids.remove(id);
                    System.out.println("Employee deleted");
                } else {
                    System.out.println("Not found");
                }

            } else if (ch == 5) {
                for (Employee e : list)
                    System.out.println(e);

            } else if (ch == 6) {
                try (PrintWriter pw = new PrintWriter(new FileWriter("employees.txt"))) {
                    for (Employee e : list)
                        pw.println(e.id + "," + e.name + "," + e.dept + "," + e.salary);
                }
                System.out.println("Records saved");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
