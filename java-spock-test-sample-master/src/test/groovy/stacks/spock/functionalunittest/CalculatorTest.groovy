package stacks.spock.functionalunittest

import spock.lang.Specification
import spock.lang.Unroll
import stacks.spock.functionalunittest.entities.Person
import stacks.spock.functionalunittest.servicesimpl.Calculator

import static stacks.spock.functionalunittest.servicesimpl.Calculator.take

/*

What is @Unroll annotation?

@Unroll - Each data driven iterations will be reported independently.
        - Each data driven iteration will be counted as a "test"
        - That means that your test count will increase.It will help you with your reports.

For Ex : run should calculate: #x + #y = #sum" with/without @Unroll and monitor result.
Also If you are using @Unroll please also customize your test name (for EX : #x + #y = #sum),
it will help you with your reports.

*/

@Unroll
class CalculatorTest extends Specification {

    def "should calculate: #x + #y = #sum"() {
        //expect - conditional based assertion statement
        expect:
        take(x).add(y).calculate() == sum

        //where - Used for data driven approach
        where:
        x | y  | sum
        1 | 2  | 4
        2 | 5  | 7
        3 | -1 | 2

    }

    def "should subtract numbers"() {

        //Optional field and used only once in the feature method.
        //setup variables or mocks or stubs.
        //prepare your object that you want to test
        given:
        Calculator calculator = new Calculator()
        when:
        calculator.add(4).subtract(4)
        //then : similar to "except:" block ,assertions or verification of response
        then:
        calculator.calculate() == 0

    }

    def "should multiply"() {
        //expect - conditional based assertion statement
        expect:
        (take(2) * 2).calculate() == 4

    }

    def "find out max number"() {
        //An "expect:" block is more limited than a then block in that it may only contain conditions and variable definitions.
        expect:
        Math.max(1, 3) == 3
        Math.max(2, 9) == 9
    }

    def "maximum of two numbers"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 4
        0 | 0 | 0
    }

    //This where block effectively creates two "versions" of the feature method:
    // One where a is 5, b is 1, and c is 5, and another one where a is 3, b is 9, and c is 9.
    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        //data pipes:
        //A data pipe, indicated by the left-shift (<<) operator, connects a data variable to a data provider.
        // The data provider holds all values for the variable, one per iteration
        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    def "#person.name is a #sex.toLowerCase() person"() {

        expect:
        person.getSex() == sex

        where:
        person                       || sex
        new Person("Fred","Male")    || "Male"
        new Person("Wilma","Female") || "Female"
    }


    def "HashMap accepts null key"() {

        //"setup:" and "given:" are kind of similar.
        setup:
        def map = new HashMap()

        when:
        map.put(null, "test")

        then:
        notThrown(NullPointerException)
    }
}
