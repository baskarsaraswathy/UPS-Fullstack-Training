import java.util.Scanner;

class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        if (choice == 1)
            System.out.println("Fahrenheit: " + (temp * 9 / 5 + 32));
        else if (choice == 2)
            System.out.println("Celsius: " + ((temp - 32) * 5 / 9));
        else
            System.out.println("Invalid choice");

        sc.close();
    }
}
