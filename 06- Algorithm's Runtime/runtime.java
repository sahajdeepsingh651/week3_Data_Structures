/*
import java.util.Arrays;
import java.util.Random;

public class runtime {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        System.out.printf("%-12s %-25s %-25s\n", "Dataset", "Linear Search Time (ms)", "Binary Search Time (ms)");
        System.out.println("---------------------------------------------------------------");

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 2);
            }

            int target = data[random.nextInt(size)];

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();
            long linearTime = (endLinear - startLinear) / 1_000_000;

            Arrays.sort(data);
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();
            long binaryTime = (endBinary - startBinary) / 1_000_000;

            System.out.printf("%-12d %-25d %-25d\n", size, linearTime, binaryTime);
        }
    }
}



import java.util.Arrays;
import java.util.Random;

public class runtime {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-12s %-20s %-20s %-20s\n", "Dataset", "Bubble Sort (ms)", "Merge Sort (ms)", "Quick Sort (ms)");
        System.out.println("--------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] original = new Random().ints(size, 0, size).toArray();
            int[] arr1 = Arrays.copyOf(original, original.length);
            int[] arr2 = Arrays.copyOf(original, original.length);
            int[] arr3 = Arrays.copyOf(original, original.length);

            long startBubble = System.nanoTime();
            if (size <= 10000)
                bubbleSort(arr1);
            long endBubble = System.nanoTime();
            long bubbleTime = (size <= 10000) ? (endBubble - startBubble) / 1_000_000 : -1;

            long startMerge = System.nanoTime();
            mergeSort(arr2, 0, arr2.length - 1);
            long endMerge = System.nanoTime();
            long mergeTime = (endMerge - startMerge) / 1_000_000;

            long startQuick = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            long endQuick = System.nanoTime();
            long quickTime = (endQuick - startQuick) / 1_000_000;

            System.out.printf("%-12d %-20s %-20d %-20d\n",
                    size,
                    (bubbleTime == -1 ? "Unfeasible" : bubbleTime),
                    mergeTime,
                    quickTime);
        }
    }
}



public class runtime {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-15s %-20s %-20s %-20s\n", "Operations (N)", "String (ms)", "StringBuilder (ms)", "StringBuffer (ms)");
        System.out.println("--------------------------------------------------------------------------");

        for (int n : sizes) {
            long startString = System.nanoTime();
            String str = "";
            if (n <= 10000) {
                for (int i = 0; i < n; i++) {
                    str += "a";
                }
            }
            long endString = System.nanoTime();
            long timeString = (n <= 10000) ? (endString - startString) / 1_000_000 : -1;

            long startSB = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            long endSB = System.nanoTime();
            long timeSB = (endSB - startSB) / 1_000_000;

            long startSBuf = System.nanoTime();
            StringBuffer sBuffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sBuffer.append("a");
            }
            long endSBuf = System.nanoTime();
            long timeSBuf = (endSBuf - startSBuf) / 1_000_000;

            System.out.printf("%-15d %-20s %-20d %-20d\n",
                    n,
                    (timeString == -1 ? "Unusable" : timeString),
                    timeSB,
                    timeSBuf);
        }
    }
}



import java.io.*;

public class runtime {

    public static void main(String[] args) {
        String filePath = "test.txt";

        System.out.println("Reading file: " + filePath + "\n");

        try {
            long startFR = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            BufferedReader brFR = new BufferedReader(fr);
            while (brFR.readLine() != null);
            brFR.close();
            long endFR = System.nanoTime();
            System.out.println("FileReader Time: " + (endFR - startFR) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error using FileReader: " + e.getMessage());
        }

        try {
            long startISR = System.nanoTime();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader brISR = new BufferedReader(isr);
            while (brISR.readLine() != null);
            brISR.close();
            long endISR = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (endISR - startISR) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error using InputStreamReader: " + e.getMessage());
        }
    }
}



public class runtime {

    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 30;
        int n3 = 50;

        System.out.println("Recursive Fibonacci:");
        long startRec = System.nanoTime();
        System.out.println("Fib(" + n1 + ") = " + fibonacciRecursive(n1));
        System.out.println("Time: " + (System.nanoTime() - startRec) / 1_000_000.0 + " ms");

        startRec = System.nanoTime();
        System.out.println("Fib(" + n2 + ") = " + fibonacciRecursive(n2)); // Will take several seconds
        System.out.println("Time: " + (System.nanoTime() - startRec) / 1_000_000.0 + " ms");

        System.out.println("\nIterative Fibonacci:");
        long startItr = System.nanoTime();
        System.out.println("Fib(" + n1 + ") = " + fibonacciIterative(n1));
        System.out.println("Time: " + (System.nanoTime() - startItr) / 1_000_000.0 + " ms");

        startItr = System.nanoTime();
        System.out.println("Fib(" + n2 + ") = " + fibonacciIterative(n2));
        System.out.println("Time: " + (System.nanoTime() - startItr) / 1_000_000.0 + " ms");

        startItr = System.nanoTime();
        System.out.println("Fib(" + n3 + ") = " + fibonacciIterative(n3));
        System.out.println("Time: " + (System.nanoTime() - startItr) / 1_000_000.0 + " ms");
    }
}



import java.util.*;

public class runtime {

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("\n--- Dataset Size: " + size + " ---");

            Random rand = new Random();
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(size * 2);
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }

            int target = array[size / 2];

            long start = System.nanoTime();
            boolean foundArray = false;
            for (int val : array) {
                if (val == target) {
                    foundArray = true;
                    break;
                }
            }
            long end = System.nanoTime();
            System.out.println("Array Search - Found: " + foundArray + ", Time: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundHashSet = hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search - Found: " + foundHashSet + ", Time: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundTreeSet = treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search - Found: " + foundTreeSet + ", Time: " + (end - start) / 1_000_000.0 + " ms");
        }
    }
}
 */