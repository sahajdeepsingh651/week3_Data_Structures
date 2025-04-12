import java.util.*;

public class SubarraysWithZeroSum {

    // Function to find all subarrays with zero sum
    public static List<List<Integer>> findSubarraysWithZeroSum(int[] arr) {
        // HashMap to store the cumulative sum and its corresponding indices
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int cumulativeSum = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            cumulativeSum += arr[i];

            // Check if the cumulative sum is zero
            if (cumulativeSum == 0) {
                result.add(Arrays.asList(0, i));
            }

            // If the cumulative sum is already in the map, it means we found a subarray with sum zero
            if (sumMap.containsKey(cumulativeSum)) {
                // Get the list of indices where this cumulative sum occurred before
                List<Integer> indices = sumMap.get(cumulativeSum);

                // For each previous index, there is a subarray from that index+1 to the current index
                for (int index : indices) {
                    result.add(Arrays.asList(index + 1, i));
                }
            }

            // Add the current index to the list of indices for this cumulative sum
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, 2, 1, 4, -4, 3, -1};

        List<List<Integer>> subarrays = findSubarraysWithZeroSum(arr);

        // Display the subarrays with zero sum
        if (subarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            for (List<Integer> subarray : subarrays) {
                System.out.println("Subarray with zero sum: " + arr[subarray.get(0)] + " to " + arr[subarray.get(1)]);
            }
        }
    }
}
