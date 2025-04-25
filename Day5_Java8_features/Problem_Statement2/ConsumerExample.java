import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "cherry");

        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        items.forEach(printUpperCase);
    }
}