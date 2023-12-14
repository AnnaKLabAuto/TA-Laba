package solvd.training.student.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static volatile BlockingQueue<Connection> pool;
    private static final int poolSize = 5;
    private static final Semaphore semaphore = new Semaphore(poolSize, true);
    private static final CountDownLatch latch = new CountDownLatch(2);

    public ConnectionPool() {}

    public static synchronized BlockingQueue<Connection> getPool() {
        if (pool == null) {
            synchronized (ConnectionPool.class) {
                if (pool == null) {
                    pool = new ArrayBlockingQueue<>(poolSize);
                    for (int i = 0; i < poolSize; i++) {
                        pool.add(new Connection());
                    }
                }
            }
        }
        return pool;
    }

    public static Connection acquireConnection() throws InterruptedException {
        semaphore.acquire();
        latch.countDown();
        latch.await();
        return new Connection();
    }

    public static void releaseConnection(Connection connection) {
        semaphore.release();
    }

}