public class InsertionSort {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        // Traverse through 1 to n-1
        for (int i = 1; i < n; i++) {
            int current = employeeIDs[i]; // The element to be inserted
            int j = i - 1;

            // Shift elements of the sorted part that are greater than the current element
            while (j >= 0 && employeeIDs[j] > current) {
                employeeIDs[j + 1] = employeeIDs[j]; // Move elements one position to the right
                j = j - 1;
            }

            // Insert the current element at its correct position
            employeeIDs[j + 1] = current;
        }
    }

    // Method to print the array
    public static void printArray(int[] employeeIDs) {
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of employee IDs
        int[] employeeIDs = {1023, 2345, 1234, 4567, 7890, 5678, 3456};

        System.out.println("Original Employee IDs:");
        printArray(employeeIDs);

        // Sorting the employee IDs using Insertion Sort
        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs in Ascending Order:");
        printArray(employeeIDs);
    }
}
