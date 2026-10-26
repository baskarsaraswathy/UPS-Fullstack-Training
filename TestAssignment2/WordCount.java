import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String s = "java is easy and java is powerful";
        HashMap<String, Integer> map = new HashMap<>();

        if (s.trim().isEmpty()) {
            System.out.println("Empty sentence");
            return;
        }

        String words[] = s.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }

        System.out.println(map);
    }
}
