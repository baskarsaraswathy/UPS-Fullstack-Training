public class Armstrong {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            int n = i, sum = 0;

            while (n > 0) {
                int r = n % 10;
                sum = sum + (r * r * r);
                n = n / 10;
            }

            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
}
