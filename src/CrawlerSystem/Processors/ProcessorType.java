package CrawlerSystem.Processors;

import CrawlerSystem.Constants.ErrorMessages;

/**
 * ProcessorType is an enum class that represents the type of the processor.
 */
public enum ProcessorType {
    IMAGE;

    public static ProcessorType fromContentType(String contentType) throws IllegalArgumentException {
        if (contentType.startsWith("image")) {
            return IMAGE;
        } else {
            throw new IllegalArgumentException(ErrorMessages.CONTENT_TYPE_ERROR + contentType);
        }
    }
}