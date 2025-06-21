// DesignPattern: Exercise 3

package Week1_DesignPatternsAndPrinciples.Exercise3_Builder;

public class BuilderPatternExample {

    // Computer class
    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        public void showConfig() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + graphicsCard);
            System.out.println("Operating System: " + operatingSystem);
            System.out.println("-x-");
        }

        static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        gamingPC.showConfig();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("500GB HDD")
                .setOperatingSystem("Windows 10")
                .build();

        officePC.showConfig();
    }
}
