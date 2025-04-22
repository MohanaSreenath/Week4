public class MultipleCatchExample {
    public static void getElement(int[] array, int index) {
        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        getElement(numbers, 5);
    }
}