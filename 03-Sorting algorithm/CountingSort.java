public class CountingSort {

    // Method to perform Counting Sort on student ages
    public static void countingSort(int[] ages) {
        int minAge = 10;  // Minimum age in the given range
        int maxAge = 18;  // Maximum age in the given range

        // Step 1: Create a count array to store the frequency of each age
        int[] count = new int[maxAge - minAge + 1];

        // Step 2: Count the frequency of each age in the input array
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        // Step 3: Compute cumulative frequencies (for sorting)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Create an output array to store sorted ages
        int[] output = new int[ages.length];

        // Step 5: Place elements in their correct positions in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Step 6: Copy the sorted elements back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Method to print the sorted array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of student ages
        int[] studentAges = {12, 15, 18, 10, 13, 17, 16, 11, 14, 15};

        System.out.println("Original Student Ages:");
        printArray(studentAges);

        // Sorting the student ages using Counting Sort
        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}
