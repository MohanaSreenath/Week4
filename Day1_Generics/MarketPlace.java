package Bridgelabz.Generics;

import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }
}

class Catalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }

    public List<Product<? extends ProductCategory>> getProducts() {
        return products;
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * (percentage / 100));
        product.setPrice(discountedPrice);
    }
}

public class MarketPlace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<BookCategory> book = new Product<>("The Great Gatsby", 500, new BookCategory());
        Product<ClothingCategory> clothing = new Product<>("T-Shirt", 300, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Smartphone", 15000, new GadgetCategory());

        catalog.addProduct(book);
        catalog.addProduct(clothing);
        catalog.addProduct(gadget);

        System.out.println("Before Discount:");
        for (Product<? extends ProductCategory> product : catalog.getProducts()) {
            System.out.println(product.getName() + " (" + product.getCategory().getCategoryName() + "): ₹" + product.getPrice());
        }

        Catalog.applyDiscount(book, 10);
        Catalog.applyDiscount(clothing, 20);
        Catalog.applyDiscount(gadget, 15);

        System.out.println("\nAfter Discount:");
        for (Product<? extends ProductCategory> product : catalog.getProducts()) {
            System.out.println(product.getName() + " (" + product.getCategory().getCategoryName() + "): ₹" + product.getPrice());
        }
    }
}