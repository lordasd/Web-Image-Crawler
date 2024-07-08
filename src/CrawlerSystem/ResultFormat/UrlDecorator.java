package CrawlerSystem.ResultFormat;


import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * UrlDecorator class
 */
public class UrlDecorator extends FormatDecorator {
    /**
     * UrlDecorator constructor
     * @param componentFormat ComponentFormat
     */
    public UrlDecorator(ComponentFormat componentFormat) {
        super(componentFormat); // Correctly pass the previous component
    }

    /**
     * Combines the previous component with the current component string
     * @param httpHandler HttpConnection
     * @return String
     */
    @Override
    public String operation(HttpConnection httpHandler) {
        return super.operation(httpHandler) + httpHandler.getURL() + " ";
    }
}