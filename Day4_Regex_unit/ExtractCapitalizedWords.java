import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]+\\b").matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println(extractCapitalizedWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York."));
    }
}