package Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Freq {

    // Method to calculate the frequency of elements in a List
    public static <T> Map<T, Integer> calculateFrequency(List<T> list) {
        Map<T, Integer> frequencyMap = new HashMap<>();
        for (T element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        // Example usage with ArrayList
        List<Integer> arrayList = List.of(1, 2, 2, 3, 3, 3, 4, 5, 5);
        System.out.println("Input List: " + arrayList);
        Map<Integer, Integer> frequencyMap = calculateFrequency(arrayList);
        System.out.println("Frequency Map: " + frequencyMap);
    }
}