package stacks.spock.webservicetest

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject
import stacks.spock.functionalunittest.interfaces.CustomerRepository
import stacks.spock.webservicetest.controller.CustomerController
import stacks.spock.webservicetest.entities.Customer

/**
 * Test using Spring MockMvc
 */

class CustomerControllerSpec extends Specification {
    MockMvc mockMvc
    def repository
    ObjectMapper mapper = new ObjectMapper()
    def requestUri = '/api/customer'
    def groovyRequestUri = '/api/welcome'

    Customer jon
    String jonJsonString

    // run before every feature method
    void setup() {
        // Don't want to call real service which connects to db, so use mock
        repository = Mock(CustomerRepository)

        // Init controller with mock:
        //Basically, we can use def where we don’t care about the type
        def @Subject controller = new CustomerController(repository: repository)

        // Let Spring MVC Test process the controller - also print req/response in console
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()

        jon = new Customer()
        jon.setId(1)
        jon.setGivenName('mock')
        jon.setSurname('mock')

        //convert to json string object.
        jonJsonString = mapper.writeValueAsString(jon)
    }

    void 'get customer returns a single customer'() {
        given:
        1 * repository.findById('1') >> jon

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(requestUri + '/{id}', '1'))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jonJsonString))
    }


    void 'save customer'() {

        //any argument is specified as follows in groovy (_).For ex: repository.save(_)
        //testing void method : repository.save returns void but in groovy you can specify it returns null
        given:
        1 * repository.save(_) >> null

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .post(requestUri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jonJsonString))
                .andExpect(MockMvcResultMatchers.status().isOk())
    }

    //    Note : below test is for the controller written in Groovy
    //    Run the test from terminal using following command -> curl localhost:8080/api/welcome
    void 'get groovy customer returns a single groovy customer'() {

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(groovyRequestUri))
                .andExpect(MockMvcResultMatchers.status().isOk())
    }

}
