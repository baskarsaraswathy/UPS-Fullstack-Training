class Circle extends Shape {
    @Override
    void display() {
        System.out.println("This is a circle");
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.display();
    }
}
