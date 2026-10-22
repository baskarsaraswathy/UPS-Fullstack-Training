public class Dupli {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 4, 1, 5};
        System.out.println("Duplicate elements:");
        for (int i = 0; i < a.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (a[k] == a[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted) continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }
}
