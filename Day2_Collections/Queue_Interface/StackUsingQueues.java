import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int value) {
        queue1.add(value);
    }

    public int pop() {
        if (queue1.isEmpty()) return -1;
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int popped = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return popped;
    }

    public int top() {
        if (queue1.isEmpty()) return -1;
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int top = queue1.peek();
        queue2.add(queue1.remove());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Top Element After Pop: " + stack.top());
    }
}