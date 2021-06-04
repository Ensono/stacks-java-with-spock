package stacks.spock.webservicetest

import groovyx.net.http.HttpBuilder
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.*

/**
 * Rest Api tests using Groovy Rest client
 *
 * You can use either TestRestTemplate or RESTClient
 * @Autowired
 * TestRestTemplate restTemplate
 * RESTClient
 *
 * @author Suresh
 */

//@Stepwise : Indicates that a spec's feature methods should be run sequentially in their declared order
@Stepwise
@SpringBootTest
class WarehouseControllerSpec extends Specification {

    //you can create RESTClient object either way
    @Shared
    def client = HttpBuilder.configure {
        request.uri = 'http://localhost:8080'
    }

    //GET METHOD
    def "Check Api status"() {
        when: "a api call is made to /status endpoint"
        def response = client.get {
            request.uri.path = "/status"
            request.contentType = 'application/json'
        }

        then: "the appropriate message is expected"
        with(response) {
            data.text == "Active and Running"
            status == 200
        }
    }


    //DELETE METHOD
    def "Remove all products"() {
        given: "a api call is made to /products endpoint"
        client.delete(path: "products")

        when: "a product list is requested"
        def response = client.get(path: "products")

        then: "the list should be empty"
        with(response) {
            data.isEmpty()
            status == 200
        }
    }

    //POST METHOD
    def "Creating a product"() {
        when: "a new product is created"
        def response = client.post(path: "products")

        and: "product list is requested again"
        def listResponse = client.get(path: "products")

        then: "response should have default values"
        with(response) {
            data.name == "test product"
            data.stock == 10
            data.price == 0
            status == 200
        }

        and: "list should contain product"
        listResponse.data.size() > 0
    }


    //passing request body
    def 'User Should be able to perform Create Request'() {

        given:
        def requestBody = [firstName: 'amido', lastName: 'spock', email: 'amido.spock@gmail.com']

        when:
        def response = client.post(path: '/employees', body: requestBody, requestContentType: 'application/json')

        then:
        response.status == 200
    }

}
