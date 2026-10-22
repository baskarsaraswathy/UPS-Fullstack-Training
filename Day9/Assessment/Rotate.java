public class Rotate {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int first = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = first;
        for (int n : a) System.out.print(n + " ");
        System.out.println();
    }
}
