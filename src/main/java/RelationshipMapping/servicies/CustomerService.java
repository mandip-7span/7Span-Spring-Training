package RelationshipMapping.servicies;

import RelationshipMapping.entities.Customer;
import RelationshipMapping.entities.PhoneNumber;
import RelationshipMapping.repos.CustomerRepository;
import RelationshipMapping.repos.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public List<Customer> addCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            // Ensure bidirectional relationship for each customer
            for (PhoneNumber number : customer.getNumbers()) {
                number.setCustomer(customer);
            }
        }
        return customerRepository.saveAll(customers);
    }

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = customerRepository.findById(id);

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();

            // Update customer name
            existingCustomer.setName(updatedCustomer.getName());

            // Update phone numbers
            Set<PhoneNumber> newNumbers = new HashSet<>();

            for (PhoneNumber updatedNumber : updatedCustomer.getNumbers()) {
                if (updatedNumber.getId() != null) {   // Check if id is not null
                    // Update existing number
                    PhoneNumber existingNumber = phoneNumberRepository.findById(updatedNumber.getId())
                            .orElseThrow(() -> new RuntimeException("Phone number not found"));

                    existingNumber.setNumber(updatedNumber.getNumber());
                    existingNumber.setType(updatedNumber.getType());
                    existingNumber.setCustomer(existingCustomer);

                    newNumbers.add(existingNumber);
                } else {
                    // Add new number
                    updatedNumber.setCustomer(existingCustomer);
                    newNumbers.add(updatedNumber);
                }
            }


            // Remove phone numbers that are not in the update request
            existingCustomer.getNumbers().clear();
            existingCustomer.getNumbers().addAll(newNumbers);

            return customerRepository.save(existingCustomer);
        }

        return null;
    }

}
