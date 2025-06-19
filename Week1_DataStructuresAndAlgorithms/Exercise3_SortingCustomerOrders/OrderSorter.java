// DSA: Exercise 3

package Week1.DSA.Exercise3;

public class OrderSorter {

    // Order class
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String toString() {
            return "[" + orderId + "] " + customerName + " - " + totalPrice;
        }
    }

    // Bubble Sort (ascending)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort (ascending)
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    // Partition
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Print
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Clone order array (for fair sorting comparison)
    public static Order[] cloneOrders(Order[] original) {
        Order[] clone = new Order[original.length];
        for (int i = 0; i < original.length; i++) {
            clone[i] = new Order(original[i].orderId, original[i].customerName, original[i].totalPrice);
        }
        return clone;
    }

    public static void main(String[] args) {
        Order[] originalOrders = {
                new Order(201, "Alice", 1500.00),
                new Order(202, "Bob", 750.00),
                new Order(203, "Charlie", 2450.50),
                new Order(204, "Diana", 500.25),
                new Order(205, "Evan", 1200.75)
        };

        System.out.println("Bubble Sort:");
        Order[] bubbleSorted = cloneOrders(originalOrders);
        bubbleSort(bubbleSorted);
        printOrders(bubbleSorted);

        System.out.println("\nQuick Sort:");
        Order[] quickSorted = cloneOrders(originalOrders);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders(quickSorted);
    }
}

// Why Quick Sort is Preferred:
// 1. Efficiency: Quick Sort has an average time complexity of O(n log n),
// making it faster than Bubble Sort's O(n^2) for larger datasets.
// 2. Divide and Conquer: It efficiently divides the array into smaller
// sub-arrays, leading to better performance.