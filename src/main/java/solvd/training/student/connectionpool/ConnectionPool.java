package solvd.training.student.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;

import static solvd.training.student.logger.LoggerUtil.logger;

public class ConnectionPool {

    private static volatile BlockingQueue<Connection> pool;
    private static final int poolSize = 5;

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
        BlockingQueue<Connection> pool = getPool();
        Connection connection = pool.take();
        logger.info("Thread acquired connection: " + connection);
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        BlockingQueue<Connection> pool = getPool();
        pool.add(connection);
        logger.info("Thread released connection: " + connection);
    }

    public static CompletableFuture<Connection> acquireConnectionAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return acquireConnection();
            } catch (InterruptedException e) {
                throw new RuntimeException("Error acquiring connection", e);
            }
        });
    }
}