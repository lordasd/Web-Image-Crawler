package CrawlerSystem.ResultFormat;

import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * ComponentFormat abstract class
 */
public abstract class FormatDecorator implements ComponentFormat {
    protected ComponentFormat component;

    /**
     * Constructor
     * @param component ComponentFormat
     */
    public FormatDecorator(ComponentFormat component) {
        this.component = component;
    }

    /**
     * Operation on the component
     * @param httpHandler HttpConnection
     * @return String
     */
    @Override
    public String operation(HttpConnection httpHandler) {
        return component.operation(httpHandler);
    }
}
