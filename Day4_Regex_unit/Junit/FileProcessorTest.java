import java.io.*;

class FileProcessor {
    void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) { writer.write(content); }
    }

    String readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { return reader.readLine(); }
    }
}

public class FileProcessorTest {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        String filename = "test.txt";

        try {
            processor.writeToFile(filename, "Hello, World!");
            System.out.println("File Content: " + processor.readFromFile(filename));
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}