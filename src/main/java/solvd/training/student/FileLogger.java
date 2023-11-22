package solvd.training.student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileLogger {

    private static final Logger logger = LogManager.getLogger(FileLogger.class);

    public static void main(String[] args) {
        try {
            logger.info("This is a log message");
            logger.debug("This is debug message");

        } catch (Exception e) {
            System.out.println("Error logging to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}