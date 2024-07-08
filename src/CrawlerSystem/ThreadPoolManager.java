package CrawlerSystem;

import CrawlerSystem.Constants.ErrorMessages;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolManager class to manage the thread pool.
 * Submit tasks to the thread pool and shutdown the thread pool.
 */
public class ThreadPoolManager {
    private final ExecutorService executor;

    /**
     * Constructor to initialize the ThreadPoolManager.
     * @param poolSize - size of the thread pool.
     */
    public ThreadPoolManager(int poolSize) {
        if (poolSize <= 0) {
            throw new IllegalArgumentException(ErrorMessages.POOL_SIZE_ERROR);
        }
        executor = Executors.newFixedThreadPool(poolSize);
    }

    /**
     * Method to submit a task to the thread pool.
     * @param task - task to be submitted.
     */
    public void submitTask(Runnable task) {
        executor.execute(task);
    }

    /**
     * Method to shut down the thread pool.
     */
    public void shutdown() {
        executor.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                // Wait a while for tasks to respond to being cancelled
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println(ErrorMessages.SHUTDOWN_THREAD_POOL_ERROR);
                }
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
