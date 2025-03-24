package RelationshipMapping.controller;

import RelationshipMapping.entities.Customer;
import RelationshipMapping.servicies.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    @Transactional
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping("/addCustomer")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return customerService.addCustomers(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer updatedCustomer) {

        Customer customer = customerService.updateCustomer(id, updatedCustomer);

        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
