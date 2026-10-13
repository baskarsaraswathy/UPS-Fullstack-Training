public class Anagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        for (int i = 0; i < a.length; i++) {
            boolean found = false;

            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    b[j] = '\0'; // Mark this character as used
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Not Anagram");
                return;
            }
        }

        System.out.println("Anagram");
    }
}
