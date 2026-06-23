/**
 * Q3: Use the Two-Pointer technique to find all pairs that sum to 16 in a sorted array.
 */
public class Q3_TwoPointer {
    public static void findPairs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        boolean foundAny = false;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                foundAny = true;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        if (!foundAny) {
            System.out.println("No pairs found that add up to " + target);
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int targetSum = 16;
        System.out.println("Sorted array: {1, 3, 5, 7, 9, 11, 13, 15}");
        System.out.println("Target sum: " + targetSum);
        findPairs(sortedArray, targetSum);
    }
}
