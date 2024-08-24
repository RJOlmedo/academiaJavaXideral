import java.util.*;
import java.util.stream.*;

class Product {
    String category;
    String name;
    double price;

    Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (Category: " + category + ", Price: $" + price + ")";
    }
}

public class productCatalog {
    public static void main(String[] args) {
        List<List<Product>> productCatalog = Arrays.asList(
            Arrays.asList(
                new Product("Electronics", "Laptop Gamer", 1200),
                new Product("Electronics", "iPhone", 800),
                new Product("Electronics", "iPad", 600)
            ),
            Arrays.asList(
                new Product("Furniture", "Herman MillerChair", 150),
                new Product("Furniture", "Mobelart Table", 300),
                new Product("Furniture", "Gamer Lamp", 80)
            ),
            Arrays.asList(
                new Product("Electronics", "Samsung Smart TV", 1800),
                new Product("Electronics", "Airpods", 250),
                new Product("Electronics", "Camera", 900)
            )
        );

        List<Product> discountedElectronics = productCatalog.stream()
            .flatMap(Collection::stream)                       // Intermediate Operation 1: Flatten the nested list
            .filter(p -> p.getCategory().equals("Electronics")) // Intermediate Operation 2: Filter Electronics category
            .filter(p -> p.getPrice() > 500)                   // Intermediate Operation 3: Filter products > $500
            .map(p -> new Product(p.getCategory(), p.getName(), p.getPrice() * 0.9)) // Intermediate Operation 4: Apply 10% discount
            .sorted(Comparator.comparingDouble(Product::getPrice)) // Intermediate Operation 5: Sort by price ascending
            .limit(5)                                           // Intermediate Operation 6: Limit to top 5
            .collect(Collectors.toList());                      // Terminal Operation: Collect to a list

        System.out.println("Top 5 Discounted Electronics Products:");
        discountedElectronics.forEach(System.out::println);
    }
}
