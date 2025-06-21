// DSA: Exercise 2

import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {

    // Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "[" + productId + "] " + productName + " (" + category + ")";
        }
    }

    // Linear search by productName
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Binary search by productName (requires sorted array)
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shampoo", "Personal Care"),
                new Product(103, "Mouse", "Electronics"),
                new Product(104, "Notebook", "Stationery"),
                new Product(105, "Keyboard", "Electronics")
        };

        System.out.println("Linear Search Result:");
        String targetName = "Notebook";
        Product result1 = linearSearch(products, targetName);
        System.out.println(result1 != null ? result1 : targetName + " not found");

        // Sort the array before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search Result:");
        String targetName2 = "Mouse";
        Product result2 = binarySearch(products, targetName2);
        System.out.println(result2 != null ? result2 : targetName2 + " not found");
    }
}

// Understand Asymptotic Notation:
// Big O describes the upper bound of an algorithm's running time as the input
// size grows.
// For linear search, the time complexity is O(n) because it may need to check
// each element.
// For binary search, the time complexity is O(log n) because it divides the
// search space in half each time.