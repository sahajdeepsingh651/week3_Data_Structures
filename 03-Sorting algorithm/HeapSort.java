public class HeapSort {

    // Method to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // One by one extract elements from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (max) element with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to maintain the heap property
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than root
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and heapify the affected subtree
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Method to print the array
    public static void printArray(int[] salaries) {
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of job applicants' expected salary demands
        int[] salaryDemands = {50000, 80000, 30000, 60000, 75000, 95000, 120000, 65000};

        System.out.println("Original Salary Demands:");
        printArray(salaryDemands);

        // Sorting the salary demands using Heap Sort
        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands in Ascending Order:");
        printArray(salaryDemands);
    }
}
