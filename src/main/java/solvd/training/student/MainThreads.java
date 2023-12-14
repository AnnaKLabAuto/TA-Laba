package solvd.training.student;

import static solvd.training.student.utils.LoggerUtil.logger;
import solvd.training.student.utils.Connection;
import solvd.training.student.utils.ConnectionPool;
import solvd.training.student.threads.ConnectionThread;
import java.util.concurrent.*;

public class MainThreads {
    public static void main(String[] args){

        ConnectionThread threadC = new ConnectionThread();
        threadC.start();

        Runnable task = () -> logger.info("Custom thread2 running...");
        Thread th = new Thread(task);
        th.start();

        //Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the
        //connection. 2 Threads should wait for the next available connection. The program should wait as well.
        ExecutorService executor = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                Connection connection = null;
                try {
                    connection = ConnectionPool.acquireConnection();
                    logger.info("Thread acquired connection: " + connection);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                    Thread.currentThread().interrupt();
                } finally {
                    ConnectionPool.releaseConnection(connection);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        logger.info("All threads finished");


        // Implement 4th part but with IFuture and CompletableStage.
        ConnectionPool.getPool();
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        CompletableFuture<Void>[] futures = new CompletableFuture[7];

        for (int i = 0; i < 7; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = ConnectionPool.acquireConnection();
                    connection.executeQuery("SELECT * FROM");
                    ConnectionPool.releaseConnection(connection);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executorService);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        allOf.join();
        executorService.shutdown();

    }
}
