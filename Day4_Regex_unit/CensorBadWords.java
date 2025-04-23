public class CensorBadWords {
    public static String censor(String text) {
        return text.replaceAll("\\b(damn|stupid)\\b", "****");
    }

    public static void main(String[] args) {
        System.out.println(censor("This is a damn bad example with some stupid words."));
    }
}