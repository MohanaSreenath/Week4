import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}

public class DateFormatterTest {
    public static void main(String[] args) {
        DateFormatter formatter = new DateFormatter();

        try {
            System.out.println("Formatted Date: " + formatter.formatDate("2024-08-15"));
            System.out.println("Formatted Date: " + formatter.formatDate("15/08/2024")); // Invalid case
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format");
        }
    }
}