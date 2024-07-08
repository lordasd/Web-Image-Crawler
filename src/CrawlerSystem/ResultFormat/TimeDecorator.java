package CrawlerSystem.ResultFormat;


import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * TimeDecorator class
 */
public class TimeDecorator extends FormatDecorator {
    /**
     * TimeDecorator constructor
     * @param componentFormat ComponentFormat
     */
    public TimeDecorator(ComponentFormat componentFormat) {
        super(componentFormat);
    }

    /**
     * Combines the previous component with the current component string
     * @param httpHandler HttpConnection
     * @return String
     */
    @Override
    public String operation(HttpConnection httpHandler) {
        return super.operation(httpHandler) + httpHandler.getResponseTime() + " ";
    }
}