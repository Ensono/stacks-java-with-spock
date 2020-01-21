package groovy

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


/**
 * This is a sample Groovy controller
 *
 */

@RestController
@RequestMapping(value = "/api")
class GroovyCustomerController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    String People() {
        return "people"
    }


}
