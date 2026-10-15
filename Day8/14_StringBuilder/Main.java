import java.io.FileWriter;
import java.io.IOException;
class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Java\n");
        sb.append("Multithreading\n");
        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write(sb.toString());
            System.out.println("Data saved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
