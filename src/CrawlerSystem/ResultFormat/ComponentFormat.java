package CrawlerSystem.ResultFormat;

import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * ComponentFormat interface
 */
public interface ComponentFormat {
    String operation(HttpConnection httpHandler);
}
