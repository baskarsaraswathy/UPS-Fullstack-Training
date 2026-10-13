class Welcome {
    Welcome() {
        System.out.println("Welcome!");
    }

    Welcome(String name) {
        System.out.println("Welcome " + name);
    }

    Welcome(String name, int age) {
        System.out.println("Welcome " + name + ", Age: " + age);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        new Welcome();
        new Welcome("Baskar");
        new Welcome("Baskar", 21);
    }
}
