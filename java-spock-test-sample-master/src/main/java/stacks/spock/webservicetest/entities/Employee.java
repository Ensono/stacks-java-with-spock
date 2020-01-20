package stacks.spock.webservicetest.entities;

public class Employee {

    private String firstName;
    private String lastName;
    private String email;

    Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
