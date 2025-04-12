import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the index of elements we have seen so far
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // The number we need to find

            // If complement is found in map, return the indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // If complement not found, store the current number with its index
            map.put(nums[i], i);
        }

        // If no solution found
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
