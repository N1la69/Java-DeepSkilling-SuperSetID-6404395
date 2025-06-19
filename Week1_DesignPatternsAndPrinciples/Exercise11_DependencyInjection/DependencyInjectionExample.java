// DesignPattern: Exercise 11

package Week1.DesignPattern.Exercise11;

public class DependencyInjectionExample {
    interface CustomerRepository {
        String findCustomerById(String customerId);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerById(String customerId) {
            return "Customer ID = " + customerId + ", Name = John Doe";
        }
    }

    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void showCustomer(String customerId) {
            String customerDetails = repository.findCustomerById(customerId);
            System.out.println("Retrieved: " + customerDetails);
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.showCustomer("C123");
    }
}
