interface RBI {
    void rules();
}

class SBI implements RBI {
    @Override
    public void rules() {
        System.out.println("SBI follows RBI rules with its own procedures");
    }
}

class IB implements RBI {
    @Override
    public void rules() {
        System.out.println("IB follows RBI rules with its own procedures");
    }
}

public class MultipleImplementations {
    public static void main(String[] args) {
        RBI r;

        r = new SBI();
        r.rules();

        r = new IB();
        r.rules();
    }
}
