package solvd.training.student.threads;

import static solvd.training.student.utils.LoggerUtil.log;

public class ConnectionThread extends Thread{
    @Override
    public void run() {
        log.info("Thread: " + Thread.currentThread().getName());
    }
}
