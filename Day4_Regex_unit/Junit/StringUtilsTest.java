class StringUtils {
    public String reverse(String str) { return new StringBuilder(str).reverse().toString(); }
    public boolean isPalindrome(String str) { return str.equalsIgnoreCase(reverse(str)); }
    public String toUpperCase(String str) { return str.toUpperCase(); }
}

public class StringUtilsTest {
    public static void main(String[] args) {
        StringUtils utils = new StringUtils();

        System.out.println("Reversed: " + utils.reverse("Java"));
        System.out.println("Is Palindrome: " + utils.isPalindrome("madam"));
        System.out.println("Uppercase: " + utils.toUpperCase("hello"));
    }
}