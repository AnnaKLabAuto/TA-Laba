package solvd.training.student.threads;

import static solvd.training.student.utils.LoggerUtil.logger;

public class ConnectionThread extends Thread{
    @Override
    public void run() {
        logger.info("Custom thread running with acquired connection");
    }
}
