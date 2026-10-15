import java.io.IOException;
class Main {
    static void checkFile() throws IOException {
        throw new IOException("File error");
    }
    public static void main(String[] args) {
        try {
            checkFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
