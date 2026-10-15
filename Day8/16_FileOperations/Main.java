import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        File file = new File("data.txt");
        try {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Student: Baskar\nDepartment: CSE");
            }
            System.out.println("File created and written");
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) System.out.println(sc.nextLine());
            }
            if (file.delete()) System.out.println("File deleted");
            else System.out.println("File could not be deleted");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
