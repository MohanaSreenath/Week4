import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateStrings = (str1, str2) -> str1 + " " + str2;

        System.out.println("Concatenated String: " + concatenateStrings.apply("Hello", "World"));
    }
}