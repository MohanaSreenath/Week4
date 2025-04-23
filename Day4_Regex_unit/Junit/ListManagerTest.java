import java.util.*;

class ListManager {
    public void addElement(List<Integer> list, int element) { list.add(element); }
    public void removeElement(List<Integer> list, int element) { list.remove(Integer.valueOf(element)); }
    public int getSize(List<Integer> list) { return list.size(); }
}

public class ListManagerTest {
    public static void main(String[] args) {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 5);
        manager.addElement(list, 10);
        System.out.println("List after adding: " + list);

        manager.removeElement(list, 5);
        System.out.println("List after removing: " + list);

        System.out.println("List size: " + manager.getSize(list));
    }
}