package CrawlerSystem.ResultFormat;


import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * SizeDecorator class
 */
public class SizeDecorator extends FormatDecorator {
    /**
     * SizeDecorator constructor
     * @param componentFormat ComponentFormat
     */
    public SizeDecorator(ComponentFormat componentFormat) {
        super(componentFormat);
    }

    /**
     * Combines the previous component with the current component string
     * @param httpHandler HttpConnection
     * @return String
     */
    @Override
    public String operation(HttpConnection httpHandler) {
        return super.operation(httpHandler) + httpHandler.getContentLength() + " ";
    }
}