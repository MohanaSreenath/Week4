import java.util.List;
import java.util.stream.Collectors;

public class FilterListExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Alex", "Charlie", "Aaron");
        List<String> filteredNames = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filteredNames);
    }
}