package stacksgroovy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import stacks.spock.webservicetest.entities.Customer
import stacksgroovy.CustomerServiceImpl


/**
 * This is a sample Groovy controller
 *
 */

@RestController
@RequestMapping(value = "/api")
class GroovyCustomerController {

    @Autowired
    CustomerServiceImpl service

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    String people() {
        return "people"
    }


    @GetMapping('/customerDetails/{id}')
    Customer getCustomerDetail(@PathVariable Long id) {
        return service.customerDetails(id)
    }


}
