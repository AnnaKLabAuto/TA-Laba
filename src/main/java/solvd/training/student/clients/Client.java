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

    @Override
    public void createContract() {logger.info("Creating a new contract.");}

    @Override
    public void reviewContract() {logger.info("Reviewing the contract.");}

    @Override
    public void fulfillContract() {logger.info("Fulfilling the contract.");}

    @Override
    public void terminateContract() {logger.info("Terminating the contract.");}
}
