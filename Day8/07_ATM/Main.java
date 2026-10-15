class ATM {
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " requested: " + amount);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        if (amount <= 1000) {
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread t1 = new Thread(() -> atm.withdraw(500), "Thread 1");
        Thread t2 = new Thread(() -> atm.withdraw(1500), "Thread 2");
        t1.start();
        t2.start();
    }
}
