package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Al {

    // Method to reverse a List
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        List<Integer> reversedArrayList = reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Example with LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original LinkedList: " + linkedList);
        List<Integer> reversedLinkedList = reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}