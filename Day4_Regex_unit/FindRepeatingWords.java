import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {
    public static List<String> findRepeats(String text) {
        List<String> repeats = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)").matcher(text);
        while (matcher.find()) {
            if (!repeats.contains(matcher.group())) {
                repeats.add(matcher.group());
            }
        }
        return repeats;
    }

    public static void main(String[] args) {
        System.out.println(findRepeats("This is is a repeated repeated word test."));
    }
}