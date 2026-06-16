import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentGradeBook {
    public static void main(String[] args) {

        // Create and store student names with marks
        HashMap<String, Integer> grades = new HashMap<>();

        grades.put("Alice", 85);
        grades.put("Bob", 32);
        grades.put("Carol", 91);
        grades.put("David", 67);
        grades.put("Emma", 39);

        // Print all students and their marks
        System.out.println("--- Student Grades ---");

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Find the student with the highest marks
        String topStudent = "";
        int highestMarks = -1;

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            if (entry.getValue() > highestMarks) {
                highestMarks = entry.getValue();
                topStudent = entry.getKey();
            }
        }

        System.out.println("\nTop Student: " + topStudent);
        System.out.println("Highest Marks: " + highestMarks);

        // Remove students who scored below 40
        Iterator<Map.Entry<String, Integer>> iterator =
                grades.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();

            if (entry.getValue() < 40) {
                iterator.remove();
            }
        }

        // Print updated list
        System.out.println("\n--- Updated Grade Book ---");

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}