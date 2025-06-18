// DesignPattern: Exercise 4

package Week1.DesignPattern.Exercise4;

public class AdapterPatternExample {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Gateway A
    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("Payment of " + amount + " processed via PayPal.");
        }
    }

    // Gateway B
    static class StripeGateway {
        public void makeStripePayment(double amount) {
            System.out.println("Payment of " + amount + " processed via Stripe.");
        }
    }

    // Gateway C
    static class RazorpayGateway {
        public void pay(double amountInRupees) {
            System.out.println("Payment of " + amountInRupees + " processed via Razorpay.");
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal = new PayPalGateway();

        public void processPayment(double amount) {
            paypal.sendPayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe = new StripeGateway();

        public void processPayment(double amount) {
            stripe.makeStripePayment(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpay = new RazorpayGateway();

        public void processPayment(double amount) {
            razorpay.pay(amount * 83.0);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment(250.0);

        PaymentProcessor razorpayProcessor = new RazorpayAdapter();
        razorpayProcessor.processPayment(50.0);
    }
}
