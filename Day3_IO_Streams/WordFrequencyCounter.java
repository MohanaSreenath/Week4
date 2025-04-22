import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String fileName) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCountMap;
    }

    public static void displayTopWords(Map<String, Integer> wordCountMap, int topN) {
        wordCountMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }

    public static void main(String[] args) {
        String fileName = "sample_text.txt";

        // Create a sample text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Hello world! Hello Java. This is a test. Java is powerful, Java is fun.");
        } catch (IOException e) {
            System.out.println("Error creating sample file.");
        }

        Map<String, Integer> wordCountMap = countWords(fileName);
        System.out.println("Top 5 Most Frequent Words:");
        displayTopWords(wordCountMap, 5);
    }
}