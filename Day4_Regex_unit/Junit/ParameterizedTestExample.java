class NumberUtils {
    public boolean isEven(int number) { return number % 2 == 0; }
}

public class ParameterizedTestExample {
    public static void main(String[] args) {
        NumberUtils utils = new NumberUtils();
        int[] numbers = {2, 4, 6, 7, 9};

        for (int num : numbers) {
            System.out.println("Is " + num + " even? " + utils.isEven(num));
        }
    }
}