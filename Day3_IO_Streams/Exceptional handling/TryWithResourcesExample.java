import java.io.*;

public class TryWithResourcesExample {
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void main(String[] args) {
        readFile("info.txt");
    }
}