import java.util.*;
import java.util.regex.*;

public class ExtractCurrencyValues {
    public static List<String> extractPrices(String text) {
        List<String> prices = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (matcher.find()) {
            prices.add(matcher.group());
        }
        return prices;
    }

    public static void main(String[] args) {
        System.out.println(extractPrices("The price is $45.99, and the discount is 10.50."));
    }
}