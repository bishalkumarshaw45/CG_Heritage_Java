import java.util.Arrays;
import java.util.Scanner;

/**
 * Q5: Combined DSA problem with Linear Search, Bubble Sort, Binary Search,
 * and Big-O complexity descriptions.
 */
public class Q5_CombinedDSA {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[8];

        System.out.println("Enter 8 unsorted integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int key = scanner.nextInt();
        scanner.close();

        System.out.println("Original array: " + Arrays.toString(numbers));
        int linearIndex = linearSearch(numbers, key);
        if (linearIndex < 0) {
            System.out.println("Number not found with Linear Search.");
            System.out.println("Big-O: Linear Search = O(n)");
            System.out.println("Bubble Sort = O(n^2)");
            System.out.println("Binary Search = O(log n)");
            return;
        }

        System.out.println("Linear Search found the number at index: " + linearIndex);
        System.out.println("Big-O for Linear Search = O(n)");

        bubbleSort(numbers);
        System.out.println("Array after Bubble Sort: " + Arrays.toString(numbers));
        System.out.println("Big-O for Bubble Sort = O(n^2)");

        int sortedIndex = binarySearch(numbers, key);
        if (sortedIndex >= 0) {
            System.out.println("Binary Search found the number at sorted index: " + sortedIndex);
        } else {
            System.out.println("Binary Search did not find the number after sorting.");
        }
        System.out.println("Big-O for Binary Search = O(log n)");
    }
}
