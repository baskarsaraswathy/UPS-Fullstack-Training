import java.io.*;
class StudentDAO {
    private final String file = "student.txt";
    void create(Student student) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(student.toString() + System.lineSeparator());
        }
    }
    void read() throws IOException {
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("No student records found");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        }
    }
    void delete() throws IOException {
        try (FileWriter fw = new FileWriter(file, false)) {
            // Opening in overwrite mode clears the file.
        }
        System.out.println("All student records deleted");
    }
}
