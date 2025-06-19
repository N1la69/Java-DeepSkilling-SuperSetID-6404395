// DesignPattern: Exercise 1

package Week1.DesignPattern.Exercise1;

public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {
        private static Logger instance;

        private Logger() {
            System.out.println("Logger Initialized.");
        }

        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first message.");
        logger2.log("This is the second message.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
