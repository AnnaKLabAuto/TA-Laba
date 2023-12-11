package solvd.training.student;

import static solvd.training.student.logger.LoggerUtil.logger;
import solvd.training.student.connectionpool.Connection;
import solvd.training.student.connectionpool.ConnectionPool;
import solvd.training.student.connectionpool.CustomThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThreads {
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(7);

        CustomThread threadC = new CustomThread();
        threadC.start();

        Runnable task = () -> logger.info("Custom thread2 running...");
        Thread th = new Thread(task);
        th.start();


        //Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the
        //connection. 2 Threads should wait for the next available connection. The program should wait as well.
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                Connection connection = null;
                try {
                    connection = ConnectionPool.acquireConnection();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ConnectionPool.releaseConnection(connection);
                }
            });
        }

        executor.submit(() -> {
            Connection connection = null;
            try {
                connection = ConnectionPool.acquireConnection();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                logger.info("Thread 1 acquired connection: " + connection);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ConnectionPool.releaseConnection(connection);
            }
        });

        executor.submit(() -> {
            Connection connection = null;
            try {
                connection = ConnectionPool.acquireConnection();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                logger.info("Thread 2 acquired connection: " + connection);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ConnectionPool.releaseConnection(connection);
            }
        });

        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("All threads finished");


        // Implement 4th part but with IFuture and CompletableStage.
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Connection connection = ConnectionPool.acquireConnectionAsync().get();
                ConnectionPool.releaseConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Connection connection = ConnectionPool.acquireConnectionAsync().get();
                ConnectionPool.releaseConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.join();
    }
}
