import java.util.Scanner;

class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        switch (n % 2) {
            case 0:
                System.out.println("Even");
                break;
            default:
                System.out.println("Odd");
        }
    }
}
