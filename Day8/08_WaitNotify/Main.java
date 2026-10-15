class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1 is running");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println("Thread 1 is resumed");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 is running");
                lock.notify();
                System.out.println("Thread 2 has notified");
            }
        });
        t1.start();
        try {
            Thread.sleep(500); // Demonstration aid, not a production guarantee
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        t2.start();
    }
}
