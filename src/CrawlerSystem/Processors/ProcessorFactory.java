package CrawlerSystem.Processors;

import CrawlerSystem.Constants.ErrorMessages;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory class for creating processors.
 */
public class ProcessorFactory {
    private static final Map<ProcessorType, Supplier<Processor>> map = new EnumMap<>(ProcessorType.class);

    static {
        map.put(ProcessorType.IMAGE, ImageProcessor::new);
    }

    /**
     * Create a processor of the given type.
     * @param type The type of processor to create.
     * @return The created processor.
     */
    public Processor createProcessor(ProcessorType type) {
        Supplier<Processor> processorSupplier = map.get(type);
        if (processorSupplier != null)
            return processorSupplier.get();
        else
            throw new IllegalArgumentException(ErrorMessages.PROCESSOR_REGISTER_ERROR + type);
    }
}