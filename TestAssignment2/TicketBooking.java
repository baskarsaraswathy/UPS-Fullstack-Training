class TicketCounter {
    int tickets = 10;

    synchronized void book(String name) {
        if (tickets >= 4) {
            tickets = tickets - 4;
            System.out.println(name + " booked 4 tickets");
        } else {
            System.out.println(name + " booking failed");
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) throws Exception {
        TicketCounter t = new TicketCounter();

        Thread t1 = new Thread(() -> t.book("Customer 1"));
        Thread t2 = new Thread(() -> t.book("Customer 2"));
        Thread t3 = new Thread(() -> t.book("Customer 3"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Remaining tickets: " + t.tickets);
    }
}
