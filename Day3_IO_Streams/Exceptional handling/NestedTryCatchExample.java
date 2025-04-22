public class NestedTryCatchExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int index = 2, divisor = 0;

        try {
            try {
                System.out.println("Result: " + (numbers[index] / divisor));
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}