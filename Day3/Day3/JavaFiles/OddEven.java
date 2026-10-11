import java.util.Scanner;

class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        if (start % 2 != 0) {
            start++;
        }
        while (start <= end) {
            System.out.println(start);
            start += 2;
        }
        sc.close();
    }
}
