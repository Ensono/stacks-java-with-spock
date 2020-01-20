package stacks.spock.functionalunittest.servicesimpl;

import org.springframework.stereotype.Service;
import stacks.spock.functionalunittest.interfaces.CustomerRepository;
import stacks.spock.webservicetest.entities.Customer;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findById(String id) {
        Customer customer = new Customer();
        customer.setId(Long.valueOf(1));
        customer.setGivenName("mock");
        customer.setSurname("mock");
        return customer;
    }

    @Override
    public void save(Customer customer) {

    }

}
