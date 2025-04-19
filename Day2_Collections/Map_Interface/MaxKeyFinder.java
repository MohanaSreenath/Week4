import java.util.*;

public class MaxKeyFinder {

    public static <K> K findMaxKey(Map<K, Integer> map) {
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Key with Highest Value: " + findMaxKey(inputMap));
    }
}