package solvd.training.student.clients;

import org.apache.logging.log4j.Logger;
import solvd.training.student.logger.LoggerUtil;
public final class Client implements Contractualizable {

    private String firstName;
    private String lastName;
    private String email;

    Logger logger = LoggerUtil.getLogger();

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void createContract() {logger.info("Creating a new contract");}

    @Override
    public void reviewContract() {logger.info("Reviewing the contract");}

    @Override
    public void fulfillContract() {logger.info("Fulfilling the contract");}

    @Override
    public void terminateContract() {logger.info("Terminating the contract");}
}
