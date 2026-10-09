import java.util.Scanner;

class EvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        start = (start + 1) / 2 * 2;

        while (start <= end) {
            System.out.println(start);
            start += 2;
        }
    }
}
