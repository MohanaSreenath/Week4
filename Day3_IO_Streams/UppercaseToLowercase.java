import java.io.*;

public class UppercaseToLowercase {

    public static void convertToLowercase(String sourceFile, String destinationFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File converted successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error processing file.");
        }
    }

    public static void main(String[] args) {
        String sourceFile = "uppercase_text.txt";
        String destinationFile = "lowercase_text.txt";

        // Create sample source file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile))) {
            writer.write("HELLO WORLD!\nTHIS IS JAVA FILE HANDLING.");
        } catch (IOException e) {
            System.out.println("Error creating source file.");
        }

        convertToLowercase(sourceFile, destinationFile);
    }
}