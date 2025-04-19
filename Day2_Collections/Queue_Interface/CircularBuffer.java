import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int capacity, front, rear, size;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }

    public int[] getBuffer() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBuffer()));
    }
}