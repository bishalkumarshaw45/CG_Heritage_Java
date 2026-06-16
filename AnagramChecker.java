import java.util.HashMap;

public class AnagramChecker {

    public static boolean isAnagram(String s1, String s2) {

        // Ignore spaces and case differences
        s1 = s1.replaceAll("\\s+", "").toLowerCase();
        s2 = s2.replaceAll("\\s+", "").toLowerCase();

        // If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count characters in first string
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Count characters in second string
        for (char ch : s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Compare the frequency maps
        return map1.equals(map2);
    }

    public static void main(String[] args) {

        System.out.println("listen, silent  : " +
                isAnagram("listen", "silent"));

        System.out.println("hello, world    : " +
                isAnagram("hello", "world"));

        System.out.println("triangle, integral : " +
                isAnagram("triangle", "integral"));
    }
}