import java.util.*;

public class ShoppingCart {
    private Map<String, Double> hashMap = new HashMap<>();
    private Map<String, Double> linkedHashMap = new LinkedHashMap<>();
    private Map<Double, String> treeMap = new TreeMap<>();

    public void addItem(String item, double price) {
        hashMap.put(item, price);
        linkedHashMap.put(item, price);
        treeMap.put(price, item);
    }

    public void displaySortedItems() {
        System.out.println("Items Sorted by Price: " + treeMap);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1200);
        cart.addItem("Phone", 800);
        cart.addItem("Headphones", 100);

        cart.displaySortedItems();
    }
}