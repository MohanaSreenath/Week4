package Collections;

import java.util.List;
import java.util.ArrayList;

public class RotateList {

    public static <T> List<T> rotate(List<T> list, int positions) {
        int size = list.size();
        positions %= size;
        List<T> rotatedList = new ArrayList<>(list.subList(positions, size));
        rotatedList.addAll(list.subList(0, positions));
        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = List.of(10, 20, 30, 40, 50);
        System.out.println("Input List: " + arrayList);
        List<Integer> rotatedList = rotate(arrayList, 2);
        System.out.println("Rotated List: " + rotatedList);
    }
}