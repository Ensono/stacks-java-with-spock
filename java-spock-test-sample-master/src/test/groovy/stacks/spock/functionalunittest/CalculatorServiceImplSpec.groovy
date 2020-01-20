package stacks.spock.functionalunittest

import spock.lang.Ignore
import spock.lang.Specification
import stacks.spock.functionalunittest.interfaces.CalculatorDao
import stacks.spock.functionalunittest.servicesimpl.CalculatorServiceImpl

class CalculatorServiceImplSpec extends Specification {

    // Mock objects are created with the MockingApi.Mock() method
    // Alternatively, the following Java-like syntax is supported

    CalculatorDao machineDao = Mock();
    //Below class is under test
    CalculatorServiceImpl machineService = new CalculatorServiceImpl(machineDao);

    def "should calculate and persist"() {

        //when : takes arbitrary code
        when:
            int sum = machineService.calculateAndPersist(2, 3);

        //then : conditions, exceptions ,interactions and variable definition.
        then:

        //This * expression in particular is a way to instruct Spock that it should expect exactly one call
        // to the method save in machineDao, and that this call should be mocked to return following  int value x -> x + 1
        //>> operator which means “return that”
            1 * machineDao.save(_) >> { int x -> x + 1 }
            sum == 6

    }


    //Ignore
    //To temporarily prevent a feature method from getting executed, annotate it with spock.lang.Ignore:

    @Ignore
    def "should fail"() {

        when:
            machineService.calculateAndPersist(2, 3);

        then:
            1 * machineDao.save(_) >> { throw new RuntimeException("disk corrupted") }
            thrown RuntimeException

    }

}
