package solvd.training.student.connectionpool;

import static solvd.training.student.logger.LoggerUtil.logger;

public class CustomThread extends Thread{
    @Override
    public void run() {
        logger.info("Custom thread running with acquired connection");
    }
}
