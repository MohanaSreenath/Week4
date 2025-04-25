import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCompositionExample {
    public static void main(String[] args) {
        List<String> words = List.of("elephant", "dog", "apple", "banana", "avocado");
        Predicate<String> lengthGreaterThan5 = word -> word.length() > 5;
        Predicate<String> containsA = word -> word.contains("a");

        List<String> filteredWords = words.stream()
                .filter(lengthGreaterThan5.and(containsA))
                .collect(Collectors.toList());

        System.out.println("Filtered Words: " + filteredWords);
    }
}