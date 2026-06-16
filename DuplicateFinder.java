import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder {
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2, 3, 5, 6, 5, 1, 7};

        HashMap<Integer, Integer> counts = new HashMap<>();

        // Count occurrences
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Print duplicates
        System.out.println("Duplicates are:");

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(
                    entry.getKey() + " appears " +
                    entry.getValue() + " times"
                );
            }
        }
    }
}