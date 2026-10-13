interface RBI {
    void rules();
}

class SBI implements RBI {
    @Override
    public void rules() {
        System.out.println("Follow RBI rules");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        RBI r = new SBI();
        r.rules();
    }
}
