import java.util.Scanner;

class MovieBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Movie Booking System");
        System.out.println("1. Leo");
        System.out.println("2. Jailer");
        System.out.println("3. GOAT");
        System.out.print("Select movie: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= 3) {
            switch (choice) {
                case 1:
                    System.out.println("Leo Selected");
                    break;
                case 2:
                    System.out.println("Jailer Selected");
                    break;
                case 3:
                    System.out.println("GOAT Selected");
                    break;
            }

            System.out.print("Enter tickets: ");
            int tickets = sc.nextInt();

            if (tickets > 0) {
                int total = tickets * 280;
                System.out.println("Booking Successful");
                System.out.println("Total = " + total);
            } else {
                System.out.println("Invalid Tickets");
            }
        } else {
            System.out.println("Invalid Movie");
        }
    }
}
