public class MergeSort {

    // Method to merge two halves of the array
    public static void merge(int[] prices, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Method to recursively divide the array and merge sorted subarrays
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to print the array
    public static void printArray(int[] prices) {
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array of book prices
        int[] bookPrices = {399, 299, 499, 129, 249, 599, 349};

        System.out.println("Original Book Prices:");
        printArray(bookPrices);

        // Sorting the book prices using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices in Ascending Order:");
        printArray(bookPrices);
    }
}
