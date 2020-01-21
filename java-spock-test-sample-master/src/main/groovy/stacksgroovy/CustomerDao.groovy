package stacksgroovy

import stacks.spock.webservicetest.entities.Customer

interface CustomerDao {
    Customer customerById(Long id)
}