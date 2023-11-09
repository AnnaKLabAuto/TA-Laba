package solvd.training.student.client;

import java.util.List;

public final class Client implements Contract {

    private String firstName;
    private String lastName;
    private String email;
    private List<Contract> contracts;

    public Client(String firstName, String lastName, String email, List<Contract> contracts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contracts = contracts;
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
