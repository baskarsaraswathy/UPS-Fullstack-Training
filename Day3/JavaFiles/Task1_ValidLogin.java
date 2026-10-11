class ValidLogin {
    public static void main(String[] args) {
        String username = "baskar";
        String password = "12345";

        if (username.equals("baskar")) {
            System.out.println("Valid User");
            if (password.equals("12345")) {
                System.out.println("Welcome " + username);
            } else {
                System.out.println("Invalid Password");
            }
        } else {
            System.out.println("Invalid Username");
        }
    }
}
