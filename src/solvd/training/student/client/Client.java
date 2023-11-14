package solvd.training.student.client;

public final class Client implements Contract {

    public Client(String firstName, String lastName, String email) { }

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
