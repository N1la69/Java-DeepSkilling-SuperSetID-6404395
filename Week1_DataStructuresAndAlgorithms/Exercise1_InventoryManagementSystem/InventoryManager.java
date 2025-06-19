// DSA: Exercise 1

package Week1.DSA.Exercise1;

import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "[" + productId + "] " + productName + " - Qty: " + quantity + ", Price: " + price;
    }
}

public class InventoryManager {
    private HashMap<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists!");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added.");
        }
    }

    // Update an existing product
    public void updateProduct(int productId, String name, int qty, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.setProductName(name);
            p.setQuantity(qty);
            p.setPrice(price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\nCurrent Inventory:");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        manager.addProduct(new Product(101, "Mouse", 50, 399.99));
        manager.addProduct(new Product(102, "Keyboard", 30, 799.50));

        // Updating product
        manager.updateProduct(101, "Wireless Mouse", 45, 499.99);

        // Deleting a product
        manager.deleteProduct(102);

        // Displaying current inventory
        manager.displayInventory();
    }
}

// Why Data Structures and Algorithms are Essential:
// In an inventory management system, you often deal with thousands of products.
// Efficient search, update, and deletion of product records is necessary to
// avoid delays in real-time inventory operations.
// Poorly chosen data structures can lead to slower performance, especially as
// the inventory size grows.

// Suitable Data Structures:
// HashMap: Key-value pairs make it ideal for fast access using productId as the
// key. Time complexities: O(1) for add, update, delete (on average).