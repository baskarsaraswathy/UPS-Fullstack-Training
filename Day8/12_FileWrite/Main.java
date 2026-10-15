import java.io.FileWriter;
import java.io.IOException;
class Main {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write("Hello Java");
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
