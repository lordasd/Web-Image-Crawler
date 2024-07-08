package CrawlerSystem.Constants;

/**
 * Error messages used in the application.
 */
public final class ErrorMessages {
    public static final String USAGE_MESSAGE = "Usage: java CrawlerSystem.Main <format> <poolSize> <inputFileName>";
    public static final String POOL_SIZE_ERROR = "Pool size must be greater than zero.";
    public static final String READ_INPUT_ERROR = "Failed to read input: ";
    public static final String OPEN_FILE_ERROR = "Error opening file: ";
    public static final String CLOSE_INPUT_ERROR = "Failed to close input source: ";
    public static final String INPUT_TYPE_ERROR = "Input type cannot be null";
    public static final String SHUTDOWN_THREAD_POOL_ERROR = "Failed to shutdown thread pool: ";
    public static final String URL_ERROR = "Error with URL ";
    public static final String URL_MALFORMED_ERROR = "Malformed URL: ";
    public static final String URL_UNREACHABLE_ERROR = "Failed, URL is unreachable: ";
    public static final String CONNECTION_FAILED_ERROR = "Connection failed for URL ";
    public static final String FORMAT_REGISTER_ERROR = "No format decorator registered for key: ";
    public static final String INPUT_SOURCE_REGISTER_ERROR = "No input source registered for type: ";
    public static final String PROCESSOR_REGISTER_ERROR = "No processor registered for type: ";
    public static final String CONTENT_TYPE_ERROR = "Unsupported content type: ";
    public static final String CONTENT_MISSING_ERROR = "Content is missing for URL ";
    public static final String URI_ABSOLUTE_ERROR = "URI is not absolute: ";
}
