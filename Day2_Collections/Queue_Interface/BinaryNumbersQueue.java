import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersQueue {

    public static String[] generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        String[] result = new String[n];

        queue.add("1");
        for (int i = 0; i < n; i++) {
            String binary = queue.remove();
            result[i] = binary;
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        String[] binaryNumbers = generateBinaryNumbers(n);
        System.out.println("Binary Numbers: ");
        for (String binary : binaryNumbers) {
            System.out.print(binary + " ");
        }
    }
}