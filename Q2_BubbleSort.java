import java.util.Arrays;

/**
 * Q2: Bubble Sort with pass-by-pass output.
 * This program sorts a fixed array and prints the array after each outer loop pass.
 */
public class Q2_BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Initial array: " + Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) {
                break; // array is already sorted
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 20, 35, 10, 60, 15};
        bubbleSort(data);
    }
}
