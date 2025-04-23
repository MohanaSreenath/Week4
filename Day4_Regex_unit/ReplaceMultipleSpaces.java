public class ReplaceMultipleSpaces {
    public static String cleanSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        System.out.println(cleanSpaces("This is   an example   with multiple spaces."));
    }
}