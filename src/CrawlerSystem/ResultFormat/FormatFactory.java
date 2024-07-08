package CrawlerSystem.ResultFormat;

import CrawlerSystem.Constants.ErrorMessages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * FormatFactory class
 * Factory class for creating format decorators
 */
public class FormatFactory {
    private static final Map<Character, Function<ComponentFormat, ComponentFormat>> formatRegistry = new HashMap<>();

    static {
        formatRegistry.put(FormatType.SIZE.getCode(), SizeDecorator::new);
        formatRegistry.put(FormatType.URL.getCode(), UrlDecorator::new);
        formatRegistry.put(FormatType.TIME.getCode(), TimeDecorator::new);
        formatRegistry.put(FormatType.MIME_TYPE.getCode(), MimeTypeDecorator::new);
    }

    /**
     * Create a format decorator
     * @param key Character key for the format type
     * @param component ComponentFormat
     * @return ComponentFormat
     */
    public ComponentFormat createFormatDecorator(char key, ComponentFormat component) {
        Function<ComponentFormat, ComponentFormat> decoratorSupplier = formatRegistry.get(key);
        if (decoratorSupplier != null)
            return decoratorSupplier.apply(component);
        else
            throw new IllegalArgumentException(ErrorMessages.FORMAT_REGISTER_ERROR + key);
    }
}
