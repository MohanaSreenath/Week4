import java.io.*;

public class LargeFileReader {

    public static void readErrorLines(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "large_file.txt";

        // Create a sample large file for testing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("This is a normal line.\n");
            writer.write("ERROR: Something went wrong!\n");
            writer.write("Warning: Check the system logs.\n");
            writer.write("Critical error encountered.\n");
        } catch (IOException e) {
            System.out.println("Error creating sample file.");
        }

        readErrorLines(fileName);
    }
}