import java.util.Scanner;

class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Square: " + (n * n));
        sc.close();
    }
}
