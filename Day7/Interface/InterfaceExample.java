interface Payment {
    int MAX_AMOUNT = 10000; // public static final by default

    void pay();
}

class UPI implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment using UPI");
        System.out.println("Maximum amount: " + MAX_AMOUNT);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Payment payment = new UPI();
        payment.pay();
    }
}
