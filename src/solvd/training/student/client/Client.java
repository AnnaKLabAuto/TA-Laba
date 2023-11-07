package solvd.training.student.client;

import solvd.training.student.employees.Employee;
import solvd.training.student.employees.TeamMember;

public class Client implements TeamMember, Contract {
    private String firstName;
    private String lastName;
    private String email;

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void communicateWith(Employee employee) {
        System.out.println("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }

    @Override
    public void createContract() {
        System.out.println("Creating a new contract.");
    }

    @Override
    public void reviewContract() {
        System.out.println("Reviewing the contract.");
    }

    @Override
    public void fulfillContract() {
        System.out.println("Fulfilling the contract.");
    }

    @Override
    public void terminateContract() {
        System.out.println("Terminating the contract.");
    }
}
