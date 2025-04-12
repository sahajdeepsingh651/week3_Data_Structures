public class QuickSort {

    // Method to perform the partition
    public static int partition(int[] prices, int low, int high) {
        // Choose the last element as the pivot
        int pivot = prices[high];
        int i = (low - 1); // index of the smaller element

        // Traverse through all elements except the pivot
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap the pivot element with the element at index (i + 1)
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        // Return the index where the pivot is placed
        return i + 1;
    }

    // Recursive method to apply Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort the left and right subarrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
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
        // Example array of product prices
        int[] productPrices = {399, 299, 499, 129, 249, 599, 349};

        System.out.println("Original Product Prices:");
        printArray(productPrices);

        // Sorting the product prices using Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices in Ascending Order:");
        printArray(productPrices);
    }
}
