import java.util.Scanner;

class ATM {
    private double balance = 1000;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Enter a valid amount");
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Check Balance");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    atm.deposit(sc.nextDouble());
                    break;
                case 2:
                    atm.checkBalance();
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
