public class SelectionSort {

    // Method to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update the index of the minimum element
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Method to print the array
    public static void printArray(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of student exam scores
        int[] examScores = {85, 72, 90, 67, 78, 88, 92, 76};

        System.out.println("Original Exam Scores:");
        printArray(examScores);

        // Sorting the exam scores using Selection Sort
        selectionSort(examScores);

        System.out.println("Sorted Exam Scores in Ascending Order:");
        printArray(examScores);
    }
}
