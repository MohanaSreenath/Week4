package Collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (!second.hasNext()) return null;
            second.next();
        }

        while (second.hasNext()) {
            first.next();
            second.next();
        }

        return first.next();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        System.out.println("Input List: " + linkedList);
        String nthElement = findNthFromEnd(linkedList, 2);
        System.out.println("Nth Element from End: " + nthElement);
    }
}