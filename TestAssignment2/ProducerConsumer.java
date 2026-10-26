class Buffer {
    int n;
    boolean available = false;
    boolean done = false;

    synchronized void produce() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            while (available)
                wait();

            n = i;
            available = true;
            System.out.println("Produced: " + n);
            notifyAll();
        }

        done = true;
        notifyAll();
    }

    synchronized void consume() throws InterruptedException {
        while (true) {
            while (!available && !done)
                wait();

            if (!available && done)
                break;

            System.out.println("Consumed: " + n);
            available = false;
            notifyAll();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        Buffer b = new Buffer();

        Thread t1 = new Thread(() -> {
            try {
                b.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                b.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
