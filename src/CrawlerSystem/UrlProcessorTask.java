package CrawlerSystem;

import CrawlerSystem.Constants.ErrorMessages;
import CrawlerSystem.HttpConnection.HttpConnection;
import CrawlerSystem.HttpConnection.GetHttpConnection;
import CrawlerSystem.Processors.*;
import CrawlerSystem.ResultFormat.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * UrlProcessorTask class to process the URL.
 * Connect to the URL and process the content based on the content type.
 * Use appropriate processor to process the content.
 */
public class UrlProcessorTask implements Runnable {
    private final String url;
    private final int index;
    private final String format;
    private HttpConnection httpHandler;
    private final ProcessorFactory processorFactory;

    /**
     * Constructor to initialize the UrlProcessorTask.
     * @param url Url to process
     * @param index Index of the URL
     * @param format Format of the result
     */
    public UrlProcessorTask(String url, int index, String format) {
        this.url = url;
        this.index = index;
        this.format = format;
        processorFactory = new ProcessorFactory();
    }

    /**
     * Method to process the URL.
     * Connect to the URL and process the content based on the content type.
     * Use appropriate processor to process the content.
     */
    @Override
    public void run() {
        try {
            connectThread();
            ProcessorType type = determineProcessorType(httpHandler.getContentType());
            Processor processor = processorFactory.createProcessor(type);
            processor.process(httpHandler, new ConcreteFormat(), format, index);
        } catch (MalformedURLException e) {
            System.err.println(ErrorMessages.URL_ERROR + ": " + e.getMessage());
        } catch (IOException e) {
            System.err.println(ErrorMessages.CONNECTION_FAILED_ERROR + ": " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage() + ": " + url);
        } finally {
            if (httpHandler != null)
                httpHandler.disconnect();
        }
    }

    /**
     * Method to connect to the URL.
     * @throws Exception If connection fails
     */
    private void connectThread() throws Exception {
        httpHandler = new GetHttpConnection();
        httpHandler.connect(url);
    }

    /**
     * Method to determine the processor type based on the content type.
     * @param contentType Content type of the URL
     * @return ProcessorType
     */
    private ProcessorType determineProcessorType(String contentType) {
        return ProcessorType.fromContentType(contentType);
    }
}