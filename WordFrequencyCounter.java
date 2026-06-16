import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String paragraph =
                "Java is powerful. Java is fast, and Java is fun! "
              + "Learning Java with maps is fun. Maps make Java programming fun and powerful.";

        // Remove punctuation and convert to lowercase
        paragraph = paragraph.toLowerCase()
                             .replaceAll("[^a-z0-9\\s]", "");

        // Split into words
        String[] words = paragraph.split("\\s+");

        // Count word frequencies
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word,
                    frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        // Sort by frequency (highest first)
        Collections.sort(entries,
                Comparator.comparing(Map.Entry<String, Integer>::getValue)
                          .reversed());

        // Store in LinkedHashMap to preserve sorted order
        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print all frequencies
        System.out.println("=== Word Frequencies ===");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Print top 3 words
        System.out.println("\n=== Top 3 Most Frequent Words ===");

        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {

            if (count == 3) {
                break;
            }

            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;
        }

        // Print words that appear exactly once
        System.out.println("\n=== Words Appearing Exactly Once ===");

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {

            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }

        // Bonus: Text-based bar chart
        System.out.println("\n=== Frequency Bar Chart ===");

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {

            System.out.printf("%-12s ", entry.getKey());

            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("*");
            }

            System.out.println(" (" + entry.getValue() + ")");
        }
    }
}