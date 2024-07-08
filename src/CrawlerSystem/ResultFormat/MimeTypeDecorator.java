package CrawlerSystem.ResultFormat;


import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * MimeTypeDecorator class
 */
public class MimeTypeDecorator extends FormatDecorator {
    /**
     * MimeTypeDecorator constructor
     * @param componentFormat ComponentFormat
     */
    public MimeTypeDecorator(ComponentFormat componentFormat) {
        super(componentFormat);
    }

    /**
     * Combines the previous component with the current component string
     * @param httpHandler HttpConnection
     * @return String
     */
    @Override
    public String operation(HttpConnection httpHandler) {
        return super.operation(httpHandler) + httpHandler.getContentType() + " ";
    }
}