class Main {
    synchronized void display() {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Main obj = new Main();
        Thread t1 = new Thread(obj::display, "Thread 1");
        Thread t2 = new Thread(obj::display, "Thread 2");
        t1.start();
        t2.start();
    }
}
