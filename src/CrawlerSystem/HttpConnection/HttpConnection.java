package CrawlerSystem.HttpConnection;

/**
 * Interface for HttpConnection
 */
public interface HttpConnection {
    /**
     * Connect to the given URL
     * @param url
     * @throws Exception
     */
    void connect(String url) throws Exception;

    /**
     * Get the content type of the response
     * @return content type
     */
    String getContentType();

    /**
     * Get the content length of the response
     * @return content length
     */
    int getContentLength();

    /**
     * Get the URL of the response
     * @return URL
     */
    String getURL();

    /**
     * Get the response time of the connection
     * @return response time
     */
    long getResponseTime();

    /**
     * Disconnect the connection
     */
    void disconnect();
}