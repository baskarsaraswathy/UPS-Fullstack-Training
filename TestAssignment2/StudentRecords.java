import java.io.*;
import java.util.*;

public class StudentRecords {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter("students.txt");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter ID, name and marks: ");
            fw.write(sc.nextLine() + "\n");
        }
        fw.close();

        BufferedReader br = new BufferedReader(
                new FileReader("students.txt"));

        String line, topper = "";
        int max = -1;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String a[] = line.split(",");
            int mark = Integer.parseInt(a[2].trim());

            if (mark > max) {
                max = mark;
                topper = a[1].trim();
            }
        }
        br.close();

        System.out.println("Topper: " + topper + " " + max);

        System.out.print("Enter new student record: ");
        FileWriter fw2 = new FileWriter("students.txt", true);
        fw2.write(sc.nextLine() + "\n");
        fw2.close();

        System.out.println("Record added");
    }
}
