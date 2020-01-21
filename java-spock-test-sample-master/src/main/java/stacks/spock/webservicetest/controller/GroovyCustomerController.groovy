package stacks.spock.webservicetest.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


/**
 * This is Groovy controller
 *
 */

@RestController
@RequestMapping("/api/groovy/customer")
class GroovyCustomerController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    String People() {
        return "people"
    }


}
