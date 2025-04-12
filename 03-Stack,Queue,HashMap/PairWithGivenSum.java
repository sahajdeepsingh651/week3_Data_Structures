import java.util.HashSet;

public class PairWithGivenSum {

    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store elements we have seen so far
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Traverse the array
        for (int num : arr) {
            // Check if target - current number exists in the set
            if (seenNumbers.contains(target - num)) {
                return true; // Pair found
            }
            // Otherwise, add the current number to the set
            seenNumbers.add(num);
        }

        // If no pair found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (hasPairWithSum(arr, target)) {
            System.out.println("A pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum exists.");
        }
    }
}
