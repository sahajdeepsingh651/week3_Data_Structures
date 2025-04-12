import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    // Function to find the maximum element in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // To store the maximums
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offer(i);

            // If the window is fully formed, add the current maximum to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.print("Sliding window maximums: ");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
