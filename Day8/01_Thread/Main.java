class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
            System.out.println("Thread is running")
        );
        t1.start();
    }
}
