package stacks.spock.functionalunittest.interfaces;

import stacks.spock.webservicetest.entities.Customer;

public interface CustomerRepository {

    /**
     * @param id
     * @return
     */
    Customer findById(String id);

    /**
     * @param customer
     */
    void save(Customer customer);
}
