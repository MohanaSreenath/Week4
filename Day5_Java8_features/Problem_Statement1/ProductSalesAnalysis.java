import java.util.*;
import java.util.stream.Collectors;

class Sale {
    private int productId;
    private int quantity;
    private double price;

    public Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTotalRevenue() { return quantity * price; }

    public String toString() { return productId + " - Revenue: $" + getTotalRevenue(); }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = List.of(
                new Sale(101, 12, 50),
                new Sale(102, 8, 30),
                new Sale(103, 15, 40),
                new Sale(104, 20, 60),
                new Sale(105, 5, 25)
        );

        List<Sale> filteredSales = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .sorted(Comparator.comparingDouble(Sale::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        filteredSales.forEach(System.out::println);
    }
}