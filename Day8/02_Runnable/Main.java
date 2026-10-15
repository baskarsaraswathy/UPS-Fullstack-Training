class Main {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable is running");
        Thread t1 = new Thread(task);
        t1.start();
    }
}
