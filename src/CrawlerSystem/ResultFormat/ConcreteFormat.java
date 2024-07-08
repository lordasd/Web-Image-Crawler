package CrawlerSystem.ResultFormat;

import CrawlerSystem.HttpConnection.HttpConnection;

/**
 * ConcreteFormat class
 */
public class ConcreteFormat implements ComponentFormat{
    public ConcreteFormat() {}

    @Override
    public String operation(HttpConnection httpHandler) {
        return "";
    }
}
