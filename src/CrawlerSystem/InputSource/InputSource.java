package CrawlerSystem.InputSource;

import java.io.IOException;

/**
 * Interface for input sources.
 */
public interface InputSource extends AutoCloseable {
    String readLine() throws IOException;
}