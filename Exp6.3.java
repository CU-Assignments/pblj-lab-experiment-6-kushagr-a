import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("T-shirt", "Clothing", 30),
            new Product("Jeans", "Clothing", 50),
            new Product("Sneakers", "Footwear", 100),
            new Product("Boots", "Footwear", 150),
            new Product("Smartwatch", "Electronics", 300),
            new Product("Socks", "Footwear", 20),
            new Product("TV", "Electronics", 1500),
            new Product("Boots", "Footwear", 150), // Duplicate max price case
            new Product("Jacket", "Clothing", 200)
        );

        // Group products by category
        Map<String, List<Product>> groupedProducts = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveProduct = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, 
                    Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));

        // Display results
        System.out.println("Grouped Products:");
        groupedProducts.forEach((category, productList) -> 
            System.out.println(category + ": " + productList));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveProduct.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null)));

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
