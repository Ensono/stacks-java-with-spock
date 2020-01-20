
     ******************************************************************************************************
                                           SPOCK WITH JAVA
                                 TDD ? BDD ? or something else ?? Check this out...
               "The Enterprise-ready testing and specification framework" for Java and Groovy applications.
     ******************************************************************************************************


********** INTRODUCTION :***********

Spock is a testing and specification framework for Java and Groovy applications.
Spock is compatible with most IDEs, build tools, and continuous integration servers.
Spock is a complete testing framework on top of JUnit that is designed for testing Java and groovy applications.
The tests are written in GROOVY.



************ WHY SPOCK ? ************

Junit + Jbehave + Jmock = Spock


Spock leverages the benefits of existing Java frameworks: JUnit, TestNG, JBehave, Cucumber, Mockito, JMock and EasyMock.
Spock’s main strength is that it has only one dependency.
Therefore, users don’t need different dependencies for each of these tools. Instead, they have one for Spock.
In addition, the lines of code produced by Spock are much shorter, which makes Spock tests much more readable and maintainable.

  1. Spock test is shorter.Spock code is more elegant. Moreover it is compact and much less verbose than Mockito’s.
     Superb readability, offering compatibility towards plain English sentences

  2. Spock is a framework which includes: unit testing, integration testing, mocking and stubbing.
     Other than that it is a specification of the application.
     JUnit is only a framework for unit testing and adding a Mockito (or other mocking library) is needed if mocking ability is required.

  3. JUnit test is written in pure Java which is rather known to Java programmers.
     Spock test is written in Groovy which might make some Java programmers unhappy.

  4. Mocking and Stubbing is easier than ever with Spock. Also, both are in-built.
     Shorter and crispier parameterization.
  5. Easy to learn. It really is, even if you don't know Groovy.
  6. Shorter and crispier parameterization.
  7. Offers surrounding context making it easier to figure out the cause of a failure.
  8. Expressive and simplistic DSL(Domain-Specific Language).

**** DATA DRIVEN TESTING ****

The real power of Spock appears if you want to write some more complex test and exercise the same test many times with different input data and expected results.
Such a test may be written in JUnit with use of Parametrized runner. And in Spock you just need to define data table in ‘where’ section. Please look at the examples below.

********* ADVANTAGES : *********

1) Test structure
2) Failure context
3) Test readability -> Spock test is shorter than Mockito
4) Data tables
5  Built-in Mocking -> Facilities for mocks and stubs built-in into the base package.
6) With Spock you will write unit and integration tests quickly and they will look like much more elegant.

********* DISADVANTAGES : ********

1) Groovy knowledge for SPock testing -> Groovy is a cousin language to Java. Much of your present java knowledge
                                         can be reused and extended.It would be a mistake to think that learning Groovy
                                         is like learning a new programming language from scratch.
                                         Groovy was designed as a companion to Java.

2) Compile time checks like Java could be better -> Groovy compiler will of course find syntax errors, but no type errors like Java.
                                                    This is because Groovy is a dynamic-typing programming language with powerful meta programming features
                                                    that make it impossible for the compiler to know e.g. what methods or fields a given object will have at compile time,
                                                    since it's possible for this to be changed at runtime by other code.

****************************** SPECIFICATION :**************************

A specification is represented as a Groovy class that extends from spock.lang.Specification

******** IMPORTS :********

import spock.lang.*
Package spock.lang contains the most important types for writing specifications.

class MyFirstSpecification extends Specification {
  // fields
  // fixture methods
  // feature methods
  // helper methods
}

****** TEST STRUCTURE :*****

given: creation,initialization and stubbing
 when: operation to test
 then: assertion and interaction verification

******************************** FIELDS : *********************************

def obj = new ClassUnderSpecification()
def coll = new Collaborator()

Instance fields are a good place to store objects belonging to the specification’s fixture.
It is good practice to initialize them right at the point of declaration.

@Shared res = new VeryExpensiveResource()
Sometimes you need to share an object between feature methods. For example, the object might be very expensive to create, or you might want your feature methods to interact with each other. To achieve this, declare a @Shared field.


*********************** FIXTURE or LIFE CYCLE METHODS  : ******************

Fixture methods are responsible for setting up and cleaning up the environment in which feature methods are run.

def setup() {}          // run before every feature method
def cleanup() {}        // run after every feature method
def setupSpec() {}     // run before the first feature method
def cleanupSpec() {}   // run after the last feature method

****************************** FEATURE METHODS : ***************************

Feature Methods - Feature methods are the heart of a specification. They describe the features
For Ex :

def "pushing an element on the stack"() {
  // blocks go here
}

************************** SPOCK Vs JUNIT COMPARISON *********************

 **SPOCK:**               **JUNIT:**
Specification	         Test class
setup()	                 @Before
cleanup()	             @After
setupSpec()	             @BeforeClass
cleanupSpec()	         @AfterClass
Feature	                 Test
Feature method	         Test method
Data-driven              feature Theory
Condition	             Assertion

****************************** CARDINALITY :******************************

The cardinality of an interaction describes how often a method call is expected.
It can either be a fixed number or a range:

1 * subscriber.receive("hello")      // exactly one call
0 * subscriber.receive("hello")      // zero calls
(1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
(1.._) * subscriber.receive("hello") // at least one call
(_..3) * subscriber.receive("hello") // at most three calls


****************************** ADDITIONAL LINKS :**************************

SPOCK + SPRING TEST - https://objectpartners.com/2019/05/21/speed-up-spock-spring-tests/
SPRING @WebMvcTest + SPOCK FRAMEWORK - https://allegro.tech/2018/04/Spring-WebMvcTest-with-Spock.html
SPOCK WEB CONSOLE : http://meetspock.appspot.com/  (allows to view,edit and run Spock specifications)

****************************** OFFICIAL DOCUMENTATION :*********************

http://spockframework.org/spock/docs/1.3/index.html
http://spockframework.org/spock/javadoc/1.1-rc-4/index.html


************************************* SUMMARY *******************************

The right choice of testing framework is always a matter of many factors.
If it is a brand new project,SPOCK is definitely a great consideration.
If the project is mature you can still add Spock tests along with existing JUnit tests.


Choose Junit 5 :
If you prefer
   - old good java as the only language
   - being mainstream
   - stronger compile time error checking

Choose SPOCK :
If you prefer
   - simplicity and readability
   - elegant and quickly written unit tests
   - power of groovy under the hood
   - beautiful parameterized and exception testing


***************************************************************************************************

SAMPLE APPLICATION WITH SPOCK :


Below are the steps to import the project and start exploring the SPOCK features.
I have provided examples with explanations.Please feel free to have a look and get to know SPOCK.

>>>>>>>>>>>>>>
HOW TO TEST :
>>>>>>>>>>>>>>

1) Import the project into IntelliJ or Eclipse
2) Open file SpockStackApplication. ( It is a SpringBootApplication).
3) Right Click and Run the spring boot application
4) Verify the following in console to check if the App is started successfully - Started SpockStackApplication in X seconds.

Once the Spring boot application is started, run the test file present under :  /src/test/groovy/stacks/spock

- Play around
- When test fails ,the console details the stack more elegantly.

****************************************************************************************************




