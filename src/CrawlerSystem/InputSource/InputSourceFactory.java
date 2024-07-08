package CrawlerSystem.InputSource;

import CrawlerSystem.Constants.ErrorMessages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Factory class to create input sources based on the input type.
 * The factory uses a map to store the constructors of the input sources.
 */
public class InputSourceFactory {
    private static final Map<InputType, Function<String, InputSource>> map = new HashMap<>();

    static {
        map.put(InputType.FILE, FileInputSource::new);
    }

    /**
     * Create an input source based on the input type.
     * @param type input type
     * @param source source of the input
     * @return input source
     */
    public InputSource createInputSource(InputType type, String source) {
        if (type == null) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_TYPE_ERROR);
        }
        Function<String, InputSource> constructor = map.get(type);
        if (constructor != null) {
            return constructor.apply(source);
        } else {
            throw new IllegalArgumentException(ErrorMessages.INPUT_SOURCE_REGISTER_ERROR + type);
        }
    }
}
