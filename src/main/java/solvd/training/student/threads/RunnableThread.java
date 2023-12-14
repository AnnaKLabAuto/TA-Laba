package solvd.training.student.threads;

import static solvd.training.student.utils.LoggerUtil.log;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        log.info("Runnable thread: " + Thread.currentThread().getName());
    }
}
