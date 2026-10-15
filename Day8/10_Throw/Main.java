class Main {
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Eligible");
    }
    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
