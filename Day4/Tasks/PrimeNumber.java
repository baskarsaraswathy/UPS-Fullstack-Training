import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean prime = n >= 2;

        for (int i = 2; i * i <= n && prime; i++) {
            if (n % i == 0) {
                prime = false;
            }
        }

        System.out.println(prime ? "Prime" : "Not Prime");
        sc.close();
    }
}
