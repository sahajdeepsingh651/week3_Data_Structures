import java.io.*;

public class FileReadPerformance {
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
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    public static int readUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
