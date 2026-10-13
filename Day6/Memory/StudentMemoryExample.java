class Student {
    String name = "Baskar";

    void display() {
        System.out.println(name);
    }
}

public class StudentMemoryExample {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
