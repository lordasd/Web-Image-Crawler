package CrawlerSystem.Processors;

import CrawlerSystem.HttpConnection.HttpConnection;
import CrawlerSystem.ResultFormat.ComponentFormat;

/**
 * Interface for Processor
 */
public interface Processor {
    void process(HttpConnection httpHandler, ComponentFormat component, String format, int index);
}
