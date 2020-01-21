package stacksgroovy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import stacks.spock.webservicetest.entities.Customer

@Service
class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDaoServiceImpl customerDao

    @Override
    Customer customerDetails(Long id) {
        return customerDao.customerById(id)
    }
}