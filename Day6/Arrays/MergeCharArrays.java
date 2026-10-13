public class MergeCharArrays {
    public static void main(String[] args) {
        char[] a = {'J', 'A'};
        char[] b = {'V', 'A'};
        char[] c = new char[a.length + b.length];

        for (int i = 0; i < c.length; i++) {
            if (i < a.length) {
                c[i] = a[i];
            } else {
                c[i] = b[i - a.length];
            }
        }

        System.out.println(c);
    }
}
