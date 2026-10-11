import java.util.Scanner;

class MatrixSum {
    static int[][] create(Scanner sc) {
        int[][] a = new int[3][3];

        System.out.println("Enter 9 matrix elements:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }

    static void display(int[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void add(int[][] a) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += a[i][j];
            }
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = create(sc);
        display(a);
        add(a);
        sc.close();
    }
}
