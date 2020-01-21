package stacksgroovy

import org.springframework.stereotype.Repository
import stacks.spock.webservicetest.entities.Customer

@Repository
class CustomerDaoServiceImpl implements CustomerDao {
    @Override
    Customer customerById(Long id) {
        def customer = new Customer()
        customer.setSurname("test")
        customer.setGivenName("test")
        customer.setId(id)
        return customer
    }
}
