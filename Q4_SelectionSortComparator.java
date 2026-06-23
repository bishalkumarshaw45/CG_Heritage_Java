import java.util.Arrays;
import java.util.Collections;

/**
 * Q4: Selection Sort ascending, then sort descending with Arrays.sort and Comparator.
 */
public class Q4_SelectionSortComparator {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] marks = {78, 45, 89, 23, 67, 90, 12};

        // Sort ascending using Selection Sort
        int[] ascendingMarks = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            ascendingMarks[i] = marks[i];
        }
        selectionSort(ascendingMarks);
        System.out.println("Marks sorted in ascending order: " + Arrays.toString(ascendingMarks));

        // Sort descending using Arrays.sort with Comparator
        Arrays.sort(marks, Collections.reverseOrder());
        System.out.println("Marks sorted in descending order: " + Arrays.toString(marks));
    }
}
