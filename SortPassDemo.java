import java.util.Arrays;

public class SortPassDemo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Bubble Sort Passes:");
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
                break;
            }
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Selection Sort Passes:");
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
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] bubbleData = {64, 25, 12, 22, 11};
        bubbleSort(bubbleData);

        int[] selectionData = {64, 25, 12, 22, 11};
        selectionSort(selectionData);
    }
}
