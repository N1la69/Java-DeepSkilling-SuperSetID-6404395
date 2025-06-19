// DesignPattern: Exercise 7

package Week1.DesignPattern.Exercise7;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    interface Stock {
        void registerObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;

        public StockMarket(String stockName, double stockPrice) {
            this.stockName = stockName;
            this.stockPrice = stockPrice;
        }

        public void setStockPrice(double newPrice) {
            System.out.println("\nStock price of " + stockName + " changed to: " + newPrice);
            this.stockPrice = newPrice;
            notifyObservers();
        }

        public void registerObserver(Observer o) {
            observers.add(o);
        }

        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockName, stockPrice);
            }
        }
    }

    interface Observer {
        void update(String stockName, double newPrice);
    }

    static class MobileApp implements Observer {
        private String user;

        public MobileApp(String user) {
            this.user = user;
        }

        public void update(String stockName, double newPrice) {
            System.out.println("MobileApp - " + user + ": " + stockName + " is now " + newPrice);
        }
    }

    static class WebApp implements Observer {
        private String user;

        public WebApp(String user) {
            this.user = user;
        }

        public void update(String stockName, double newPrice) {
            System.out.println("WebApp - " + user + ": " + stockName + " is now " + newPrice);
        }
    }

    public static void main(String[] args) {
        StockMarket tcsStock = new StockMarket("TCS", 3500.0);

        Observer user1 = new MobileApp("Alice");
        Observer user2 = new WebApp("Bob");
        Observer user3 = new MobileApp("Charlie");

        // Register observers
        tcsStock.registerObserver(user1);
        tcsStock.registerObserver(user2);
        tcsStock.registerObserver(user3);

        // Change stock price
        tcsStock.setStockPrice(3550.0);
        tcsStock.setStockPrice(3600.0);

        // Deregister one observer
        tcsStock.removeObserver(user2);

        // Changing stock price again
        tcsStock.setStockPrice(3650.0);
    }
}
