package solvd.training.student.threads;

import static solvd.training.student.utils.LoggerUtil.logger;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        logger.info("Runnable thread: " + Thread.currentThread().getName());
    }
}
