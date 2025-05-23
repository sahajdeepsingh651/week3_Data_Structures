import java.util.Arrays;

public class MissingPositiveAndBinarySearch {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int[] sortedCopy = nums.clone();
        Arrays.sort(sortedCopy);

        int missing = firstMissingPositive(nums);
        int index = binarySearch(sortedCopy, target);

        System.out.println("First missing positive: " + missing);

        if (index != -1)
            System.out.println("Target " + target + " found at index (in sorted array): " + index);
        else
            System.out.println("Target " + target + " not found.");
    }
}
