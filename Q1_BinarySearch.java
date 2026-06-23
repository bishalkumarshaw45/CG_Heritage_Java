import java.util.Scanner;

/**
 * Q1: Binary Search on a sorted array of 10 integers.
 * The program reads 10 sorted numbers from the user and then
 * searches for a target using Binary Search.
 */
public class Q1_BinarySearch {
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
        int[] numbers = new int[10];

        System.out.println("Enter 10 sorted integers (ascending order):");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the target number to search: ");
        int target = scanner.nextInt();
        scanner.close();

        int resultIndex = binarySearch(numbers, target);
        if (resultIndex >= 0) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found");
        }
    }
}
