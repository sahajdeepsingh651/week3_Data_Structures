
import java.util.Scanner;
public class linbin {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter word: ");
        String string = input.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.reverse();
        String reversed = sb.toString();
        System.out.println("Reversed string: "+ reversed);
    }
}

import java.util.HashSet;
public class linbin {
    public static void main(String[] args){
        String input = "sreayas";
        String result = removeDuplicates(input);
        System.out.println("Input: "+input);
        System.out.println("After removing duplicates: "+result);
    }
    public static String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(!seen.contains(ch)){
                seen.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

public class linbin {
    public static void main(String[] args) {
        String[] words = {"I", "am", "learning", "String", "Buffer"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated string: " + result);
    }
    public static String concatenateStrings(String[] str){
        StringBuffer sb = new StringBuffer();
        for(String i : str){
            sb.append(i);
        }
        return sb.toString().trim();
    }
}


public class linbin {
    public static void main(String[] args){
        int n = 1_000_000;
        String word = "hello";

        StringBuffer sbuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for(int i=0; i<n; i++){
            sbuffer.append(word);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        StringBuilder sbuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for(int i=0; i<n; i++){
            sbuilder.append(word);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: "+timeBuffer/1_000_000+"ms");
        System.out.println("Time taken by StringBuilder: "+timeBuilder/1_000_000+"ms");
    }
}


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class linbin {
    public static void main(String[] args) {
        String filePath = "example.txt"; // replace with your file name

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.println("Reading file contents:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class linbin {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "java";

        int count = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("The word \"" + targetWord + "\" appeared " + count + " times.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


import java.io.*;

public class linbin {
    public static void main(String[] args) {
        String filePath = "example.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);

            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");

            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            System.out.println("File Content:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            reader.close();
            fileInputStream.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}


import java.io.*;

public class linbin {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader consoleReader = new BufferedReader(inputStreamReader);

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Enter text to save to file (type 'exit' to finish):");

            String inputLine;

            while (true) {
                inputLine = consoleReader.readLine();

                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                bufferedWriter.write(inputLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
            consoleReader.close();
            inputStreamReader.close();

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

import java.io.*;

public class linbin {
    public static void main(String[] args) {
        String filePath = "largefile.txt";

        System.out.println("--- Reading using FileReader ---");
        long startFR = System.currentTimeMillis();
        int wordCountFR = readUsingFileReader(filePath);
        long endFR = System.currentTimeMillis();
        System.out.println("Word Count: " + wordCountFR);
        System.out.println("Time Taken with FileReader: " + (endFR - startFR) + " ms\n");

        System.out.println("--- Reading using InputStreamReader ---");
        long startISR = System.currentTimeMillis();
        int wordCountISR = readUsingInputStreamReader(filePath);
        long endISR = System.currentTimeMillis();
        System.out.println("Word Count: " + wordCountISR);
        System.out.println("Time Taken with InputStreamReader: " + (endISR - startISR) + " ms");
    }

    public static int readUsingFileReader(String filePath) {
        int wordCount = 0;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    public static int readUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}

public class linbin {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7, -3, 8, -1};

        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
            System.out.println("Value: " + arr[index]);
        } else {
            System.out.println(-1);
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}



public class linbin {
    public static void main(String[] args){
        String[] sentences = {"hi how are you","i am fine", "what about you"};
        String targetWord = "fine";
        String result = findWord(sentences, targetWord);
        System.out.println("Result: "+ result);
    }
    public static String findWord(String[] sentences, String target){
        for(String sentence : sentences){
            if(sentence.contains(target)){
                return sentence;
            }
        }
        return "Not Found";
    }
}


public class linbin {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 0, 1, 2, 3, 4 };

        int index = findRotationIndex(arr);
        System.out.println("Index of the smallest element (rotation point): " + index);
        System.out.println("Smallest element: " + arr[index]);
    }

    public static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

public class linbin {
    public static int findPeak(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left+right)/2;

            boolean leftOk = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);

            if(leftOk && rightOk){
                return arr[mid];
            }
            if (mid > 0 && arr[mid] < arr[mid-1]) {
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1, 3, 20, 4, 1, 0};
        int peak = findPeak(nums);
        System.out.println("Peak element: "+peak);
    }
}


public class linbin {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];

            if (midValue == target)
                return true;
            else if (target < midValue)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);

        System.out.println("Is target found? " + found);
    }
}



public class linbin {

    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 3, 5, 7, 8, 8, 9};
        int target = 3;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1)
            System.out.println("Element not found.");
        else {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        }
    }
}



import java.util.*;

public class linbin {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int[] copyForBinarySearch = nums.clone();
        Arrays.sort(copyForBinarySearch);

        int missing = firstMissingPositive(nums);
        int index = binarySearch(copyForBinarySearch, target);

        System.out.println("First missing positive: " + missing);

        if (index != -1)
            System.out.println("Target " + target + " found at index (in sorted array): " + index);
        else
            System.out.println("Target " + target + " not found.");
    }
}
