// DesignPattern: Exercise 5

package Week1.DesignPattern.Exercise5;

public class DecoratorPatternExample {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrapper;

        public NotifierDecorator(Notifier notifier) {
            this.wrapper = notifier;
        }

        public void send(String message) {
            wrapper.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Sending Slack Message: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier baseNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        fullNotifier.send("Server down! Immediate action required.");
    }
}
