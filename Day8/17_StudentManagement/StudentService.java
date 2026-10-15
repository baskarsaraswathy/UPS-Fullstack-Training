import java.io.IOException;
class StudentService {
    private final StudentDAO dao = new StudentDAO();
    void createStudent(Student student) throws IOException {
        dao.create(student);
    }
    void readStudents() throws IOException {
        dao.read();
    }
    void deleteStudents() throws IOException {
        dao.delete();
    }
}
