@FunctionalInterface
interface SumFunction {
    int sum(int a, int b);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        SumFunction sumFunction = (a, b) -> a + b;
        System.out.println("Sum: " + sumFunction.sum(5, 10));
    }
}