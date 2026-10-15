class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
            System.out.println("Thread method is running")
        );
        t1.start(); // New thread
        t1.run();   // Direct call on current thread
    }
}
