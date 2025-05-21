import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {

            System.out.println("Enter text to save to file (type 'exit' to finish):");
            String inputLine;

            while ((inputLine = consoleReader.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                bufferedWriter.write(inputLine);
                bufferedWriter.newLine();
            }
            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
