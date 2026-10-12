final class Vehicle {
    final int MAX_SPEED = 120;

    final void display() {
        System.out.println("Maximum speed: " + MAX_SPEED);
    }
}

class FinalExample {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.display();
    }
}
