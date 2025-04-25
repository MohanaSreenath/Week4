@FunctionalInterface
interface SquareFunction {
    int square(int num);

    default void printSquare(int num) {
        System.out.println("The square of " + num + " is " + square(num));
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        SquareFunction squareFunction = n -> n * n;
        squareFunction.printSquare(6);
    }
}