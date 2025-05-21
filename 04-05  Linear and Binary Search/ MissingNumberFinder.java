public class MissingNumberFinder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};

        int missing = findMissingNumber(arr);
        System.out.println("Missing number: " + missing);
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // Assuming one number missing in 1..n
        int totalSum = n * (n + 1) / 2;
        int arrSum = 0;

        for (int num : arr) {
            arrSum += num;
        }

        return totalSum - arrSum;
    }
}
