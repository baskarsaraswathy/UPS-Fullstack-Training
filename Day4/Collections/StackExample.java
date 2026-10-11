import java.util.Stack;

class StackExample {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s);
        System.out.println("Top: " + s.peek());
        System.out.println("Removed: " + s.pop());
        System.out.println(s);
    }
}
