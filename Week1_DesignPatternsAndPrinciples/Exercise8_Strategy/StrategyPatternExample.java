// DesignPattern: Exercise 8

package Week1.DesignPattern.Exercise8;

public class StrategyPatternExample {

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card ending with "
                    + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal account: " + email);
        }
    }

    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.paymentStrategy = strategy;
        }

        public void makePayment(double amount) {
            if (paymentStrategy == null) {
                System.out.println("No payment strategy selected.");
            } else {
                paymentStrategy.pay(amount);
            }
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Credit Card strategy
        context.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        context.makePayment(2500.00);

        // PayPal strategy
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.makePayment(1350.50);
    }
}
