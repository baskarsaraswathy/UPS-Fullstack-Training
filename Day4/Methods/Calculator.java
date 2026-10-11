import java.util.Scanner;

class Calculator {
    static int add(int a, int b) { return a + b; }
    static int sub(int a, int b) { return a - b; }
    static int mul(int a, int b) { return a * b; }

    static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + sub(a, b));
        System.out.println("Multiplication: " + mul(a, b));

        if (b != 0)
            System.out.println("Division: " + div(a, b));
        else
            System.out.println("Cannot divide by zero");

        sc.close();
    }
}
