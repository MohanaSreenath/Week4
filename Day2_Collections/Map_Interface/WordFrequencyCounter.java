import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String text) {
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println("Word Frequency: " + countWords(input));
    }
}