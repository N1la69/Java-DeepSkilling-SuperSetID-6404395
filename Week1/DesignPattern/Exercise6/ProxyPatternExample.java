// DesignPattern: Exercise 6

package Week1.DesignPattern.Exercise6;

public class ProxyPatternExample {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            } else {
                System.out.println("Image already loaded. Using cached version.");
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");
        Image image2 = new ProxyImage("mountain.png");

        // First time
        image1.display();

        // Second time
        image1.display();

        // Load another image
        image2.display();
    }
}
