class UsernamePassword {
    public static void main(String[] args) {
        String username = "baskar";
        int password = 1234;

        if (username.equals("baskar")) {
            if (password == 1234) {
                System.out.println("Welcome");
            } else {
                System.out.println("Invalid Password");
            }
        } else {
            System.out.println("Invalid Username");
        }
    }
}
