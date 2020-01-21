package stacksgroovy

import stacks.spock.webservicetest.entities.Customer

interface CustomerService {

    Customer customerDetails(Long id)

}