class RBI {
    void rules() {
        System.out.println("RBI: Follow banking rules");
    }
}

class SBI extends RBI {
    @Override
    void rules() {
        System.out.println("SBI follows RBI rules with its own procedures");
    }
}

class IB extends RBI {
    @Override
    void rules() {
        System.out.println("IB follows RBI rules with its own procedures");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        RBI r = new SBI();
        r.rules();

        r = new IB();
        r.rules();
    }
}
