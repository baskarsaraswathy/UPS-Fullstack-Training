public class SecondLargest {
    public static void main(String[] args) {
        int a[] = {12, 45, 7, 45, 32, 18};
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                second = max;
                max = a[i];
            } else if (a[i] < max && a[i] > second) {
                second = a[i];
            }
        }

        if (second == Integer.MIN_VALUE)
            System.out.println("No second largest element");
        else
            System.out.println("Second largest: " + second);
    }
}
