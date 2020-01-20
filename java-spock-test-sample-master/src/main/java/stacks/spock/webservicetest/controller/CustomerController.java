package stacks.spock.webservicetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stacks.spock.functionalunittest.interfaces.CustomerRepository;
import stacks.spock.webservicetest.entities.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        Customer customer = repository.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        repository.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

}
