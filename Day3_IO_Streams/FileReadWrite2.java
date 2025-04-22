import java.io.*;

public class FileReadWrite2 {

    public static void copyFile(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error reading or writing file.");
        }
    }

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // Create sample source file
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write("Hello, this is a sample text file.\nFile handling in Java is simple!");
        } catch (IOException e) {
            System.out.println("Error creating source file.");
        }

        copyFile(sourceFile, destinationFile);
    }
}