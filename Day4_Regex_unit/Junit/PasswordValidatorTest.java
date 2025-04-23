class PasswordValidator {
    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}

public class PasswordValidatorTest {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        System.out.println("Valid Password? " + validator.isValidPassword("Secure123"));
        System.out.println("Valid Password? " + validator.isValidPassword("weakpass"));
        System.out.println("Valid Password? " + validator.isValidPassword("NOLOWERCASE8"));
    }
}