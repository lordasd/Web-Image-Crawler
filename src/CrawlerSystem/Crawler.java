package CrawlerSystem;

import CrawlerSystem.Constants.ErrorMessages;
import CrawlerSystem.InputSource.InputSource;
import CrawlerSystem.InputSource.InputSourceFactory;
import CrawlerSystem.InputSource.InputType;

import java.util.HashSet;
import java.util.Set;

/**
 * Crawler class to start the Crawler System.
 */
public class Crawler {
    private final String format;
    private final int poolSize;
    private final InputSource inputSource;
    private final Set<String> processedUrls = new HashSet<>();
    ThreadPoolManager threadPoolManager;

    /**
     * Constructor to initialize the Crawler.
     * Create appropriate input source based on the input type.
     * @param format Character format to print the results.
     * @param poolSize Number of threads in the thread pool.
     * @param source Input source.
     * @param type Input type.
     */
    public Crawler(String format, int poolSize, String source, InputType type) {
        this.poolSize = poolSize;
        this.format = format;
        InputSourceFactory factory = new InputSourceFactory();
        this.inputSource = factory.createInputSource(type, source);
    }

    /**
     * Method to start the Crawler System.
     * Read the input source and submit tasks to the thread pool manager.
     * Print the results in order.
     */
    public void start() {
        try {
            threadPoolManager  = new ThreadPoolManager(poolSize);

            String url;
            int index = 0;
            while ((url = inputSource.readLine()) != null) {
                String trimmed_url = url.trim();
                if (trimmed_url.isEmpty() || !processedUrls.add(trimmed_url)) continue;

                UrlProcessorTask task = new UrlProcessorTask(trimmed_url, index++, format);
                threadPoolManager.submitTask(task);
            }
        } catch (Exception e) {
            System.err.println(ErrorMessages.READ_INPUT_ERROR + e.getMessage());
        } finally {
            try {
                if (inputSource != null) {
                    inputSource.close();
                }
            } catch (Exception e) {
                System.err.println(ErrorMessages.CLOSE_INPUT_ERROR + e.getMessage());
            }
            try {
                if (threadPoolManager != null) {
                    threadPoolManager.shutdown();
                }
            } catch (Exception e) {
                System.err.println(ErrorMessages.SHUTDOWN_THREAD_POOL_ERROR + e.getMessage());
            }
        }

        ThreadSafeMap.getInstance().printItemsInOrder();
    }
}
