import java.io.IOException;
class Main {
    public static void main(String[] args) throws IOException {
        StudentService service = new StudentService();
        Student student = new Student(101, "Baskar", "CSE");
        service.createStudent(student);
        service.readStudents();
        // Uncomment to clear all records:
        // service.deleteStudents();
    }
}
