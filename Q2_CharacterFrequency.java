import java.util.LinkedHashMap;
import java.util.Map;

public class Q2_CharacterFrequency {
    public static void main(String[] args) {
        String text = "programming";
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Count each character frequency using a HashMap/LinkedHashMap
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Print each character and its count
        System.out.println("Character frequency in 'programming':");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
