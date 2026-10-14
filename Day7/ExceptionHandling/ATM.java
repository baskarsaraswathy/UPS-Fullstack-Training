import java.util.Scanner;

class ATM {
    double balance = 1000;

    void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            if (amount > balance) {
                throw new Exception("Insufficient Balance");
            }

            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        atm.withdraw(amount);
        sc.close();
    }
}
