import java.util.*;
import java.util.regex.*;

public class ExtractProgrammingLanguages {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|C\\+\\+|Go)\\b", Pattern.CASE_INSENSITIVE).matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        System.out.println(extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
    }
}