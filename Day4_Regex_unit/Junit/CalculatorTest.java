class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) { if (b == 0) throw new ArithmeticException("Cannot divide by zero"); return a / b; }
}

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Addition: " + calculator.add(2, 3));
        System.out.println("Subtraction: " + calculator.subtract(3, 2));
        System.out.println("Multiplication: " + calculator.multiply(2, 3));
        
        try {
            System.out.println("Division: " + calculator.divide(6, 3));
            System.out.println("Division by Zero: " + calculator.divide(6, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}