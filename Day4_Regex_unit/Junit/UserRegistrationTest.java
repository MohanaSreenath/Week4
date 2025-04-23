class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username.isEmpty() || email.isEmpty() || password.length() < 8) {
            throw new IllegalArgumentException("Invalid user details");
        }
        System.out.println("User registered successfully.");
    }
}

public class UserRegistrationTest {
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        try {
            registration.registerUser("Alice", "alice@example.com", "password123");
            registration.registerUser("", "alice@example.com", "pass");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}