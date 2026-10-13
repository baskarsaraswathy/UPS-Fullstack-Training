class RBI {
    void rules() {
        System.out.println("RBI: Follow banking rules");
    }
}

class SBI extends RBI {
    @Override
    void rules() {
        System.out.println("SBI: RBI rules followed with SBI procedures");
    }
}

class IB extends RBI {
    @Override
    void rules() {
        System.out.println("IB: RBI rules followed with IB procedures");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        RBI r;

        r = new SBI();
        r.rules();

        r = new IB();
        r.rules();
    }
}
