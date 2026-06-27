import java.util.Arrays;
import java.util.List;

public class Q4_StudentStreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Anjali", "Riya", "Amit", "Ankit");

        System.out.println("Names starting with 'A' in uppercase and sorted:");

        // Stream pipeline:
        // 1. Filter names starting with 'A'
        // 2. Convert to uppercase
        // 3. Sort alphabetically
        // 4. Print each result
        names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
