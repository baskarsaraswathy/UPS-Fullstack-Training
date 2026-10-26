import java.util.*;

class Student {
    int roll, mark;
    String name;

    Student(int roll, String name, int mark) {
        this.roll = roll;
        this.name = name;
        this.mark = mark;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> a = new ArrayList<>();

        a.add(new Student(1, "Arun", 85));
        a.add(new Student(2, "Bala", 70));
        a.add(new Student(3, "Cathy", 90));
        a.add(new Student(4, "Devi", 65));
        a.add(new Student(5, "Evan", 80));

        System.out.println("Students above 75:");
        for (Student s : a) {
            if (s.mark > 75)
                System.out.println(s.roll + " " + s.name + " " + s.mark);
        }

        // Search and update roll number 2
        for (Student s : a) {
            if (s.roll == 2) {
                System.out.println("Found: " + s.roll + " " + s.name + " " + s.mark);
                s.mark = 78;
            }
        }

        // Remove roll number 4 and sort by marks
        a.removeIf(s -> s.roll == 4);
        a.sort((s1, s2) -> s1.mark - s2.mark);

        System.out.println("Sorted students:");
        for (Student s : a)
            System.out.println(s.roll + " " + s.name + " " + s.mark);
    }
}
