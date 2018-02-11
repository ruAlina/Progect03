import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("input.txt"));
            ArrayList<String> words = new ArrayList<>();
            for (String line : lines) {
                words.addAll(Arrays.asList(line.split("\\s+")));
            }
            Collections.sort(words);
            for (String word : words) {
                System.out.println(word);
            }
            System.out.println("\n");
            Map<String, Integer> uWords = new HashMap<>();
            for (String word : words) {
                Integer count = uWords.get(word);
                if (count == null) {
                    count = 0;
                }
                uWords.put(word, count + 1);
            }
            System.out.println(uWords + "\n");
            Collections.sort(words, new Comparator<String>() {
                @Override
                public int compare(String key1, String key2) {
                    return uWords.get(key2).compareTo(uWords.get(key1));
                }
            });
            System.out.println(words.get(0) + "=" + uWords.get(words.get(0)) + "\n");
        } catch (IOException ioex) {
            System.out.println(ioex.toString());
        }
    }
}
