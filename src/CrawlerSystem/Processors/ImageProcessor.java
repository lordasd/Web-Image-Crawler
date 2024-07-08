package CrawlerSystem.Processors;


import CrawlerSystem.HttpConnection.HttpConnection;
import CrawlerSystem.ResultFormat.ComponentFormat;
import CrawlerSystem.ResultFormat.FormatFactory;
import CrawlerSystem.ThreadSafeMap;

/**
 * This class is responsible for processing the image data.
 * It uses the ComponentFormat class to apply the necessary operations on the image data.
 */
public class ImageProcessor implements Processor {
    /**
     * Default constructor.
     */
    public ImageProcessor() {
        super();
    }

    /**
     * This method processes the image data.
     * @param httpHandler The HttpConnection object.
     * @param component The ComponentFormat object.
     * @param format The format string.
     * @param index The index for the map to store the processed data.
     */
    @Override
    public void process(HttpConnection httpHandler, ComponentFormat component, String format, int index) {
        component = buildFormat(component, format);
        String finalData = component.operation(httpHandler);
        ThreadSafeMap.getInstance().put(index, finalData);
    }

    /**
     * This method builds the format for the image data.
     * @param component The ComponentFormat object.
     * @param format The format string.
     * @return The ComponentFormat object.
     */
    private ComponentFormat buildFormat(ComponentFormat component, String format) {
        FormatFactory factory = new FormatFactory();
        for (char decoratorCode : format.toCharArray())
            component = factory.createFormatDecorator(decoratorCode, component);

        return component;
    }
}
