import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading file contents:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
