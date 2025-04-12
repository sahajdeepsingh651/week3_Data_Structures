import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) return 0;

        // Store all elements in a set for fast lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate over each number in the array
        for (int num : nums) {
            // Only start checking if num-1 is not in the set (i.e., it's the start of a sequence)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Extend the sequence by checking consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums)); // Output should be 4
    }
}
