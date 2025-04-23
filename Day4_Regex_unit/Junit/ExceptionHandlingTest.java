class ExceptionHandling {
    public int divide(int a, int b) { if (b == 0) throw new ArithmeticException("Cannot divide by zero"); return a / b; }
}

public class ExceptionHandlingTest {
    public static void main(String[] args) {
        ExceptionHandling handler = new ExceptionHandling();

        try {
            System.out.println("Result: " + handler.divide(10, 2));
            System.out.println("Result: " + handler.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}