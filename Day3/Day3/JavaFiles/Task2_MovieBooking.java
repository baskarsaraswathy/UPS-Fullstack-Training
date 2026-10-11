import java.util.Scanner;

class MovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Movie Booking System");

        while (true) {
            System.out.println("\n1. Leo");
            System.out.println("2. Jailer");
            System.out.println("3. GOAT");
            System.out.println("0. Exit");
            System.out.print("Select movie: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for visiting!");
                break;
            }

            String movie;
            switch (choice) {
                case 1: movie = "Leo"; break;
                case 2: movie = "Jailer"; break;
                case 3: movie = "GOAT"; break;
                default:
                    System.out.println("Invalid movie selection");
                    continue;
            }

            System.out.println("Movie: " + movie);
            System.out.println("1. With A/C - Rs.350");
            System.out.println("2. Without A/C - Rs.200");
            System.out.print("Select seat type: ");
            int seat = sc.nextInt();

            int price;
            if (seat == 1) {
                price = 350;
            } else if (seat == 2) {
                price = 200;
            } else {
                System.out.println("Invalid seat selection");
                continue;
            }

            System.out.print("Enter number of tickets: ");
            int tickets = sc.nextInt();

            if (tickets > 0) {
                System.out.println("Booking Successful!");
                System.out.println("Total = Rs." + (price * tickets));
            } else {
                System.out.println("Invalid ticket quantity");
            }
        }
        sc.close();
    }
}
