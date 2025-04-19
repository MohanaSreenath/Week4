package Collections;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<Integer> arrayList = List.of(3, 1, 2, 2, 3, 4);
        System.out.println("Input List: " + arrayList);
        List<Integer> uniqueList = removeDuplicates(arrayList);
        System.out.println("Unique List: " + uniqueList);
    }
}