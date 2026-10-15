import java.io.File;
class Main {
    public static void main(String[] args) {
        File file = new File("data.txt");
        System.out.println("Exists: " + file.exists());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
