import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int a[] = {10, 20, 10, 30, 20, 40, 50, 30};
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++)
            set.add(a[i]);

        System.out.println("Unique values: " + set);
        System.out.println("Count: " + set.size());
        System.out.println("Contains 40: " + set.contains(40));
    }
}
