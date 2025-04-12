public class BubbleSort {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;

        // Outer loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Flag to check if any swap occurred in this pass

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap if the current element is greater than the next
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }

            // If no swap occurred, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of student marks
        int[] studentMarks = {85, 72, 90, 65, 78, 88, 92, 75};

        System.out.println("Original Marks:");
        printArray(studentMarks);

        // Sorting the marks using Bubble Sort
        bubbleSort(studentMarks);

        System.out.println("Sorted Marks in Ascending Order:");
        printArray(studentMarks);
    }
}
