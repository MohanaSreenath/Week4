import java.util.*;

public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();

            System.out.println("Result: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}