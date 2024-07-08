# Web Image Crawler

## Project Overview
This Java-based Web Image Crawler is designed to process a list of URLs, identify image resources, and output specified information about these images. It utilizes multi-threading for efficient processing and implements various design patterns for flexibility and extensibility.

## Features
- Processes URLs from a text file input
- Multi-threaded crawling with configurable thread pool size
- Identifies and processes only image resources
- Customizable output format
- Handles various edge cases (malformed URLs, unreachable resources, etc.)

## Usage
Run the program with the following command-line arguments:
```
java Main <output_format> <pool_size> <input_file>
```
- `<output_format>`: Combination of letters (s, u, t, m) specifying output information
  - s: size of the image
  - u: URL of the image
  - t: response time
  - m: MIME type
- `<pool_size>`: Number of threads in the pool (positive non-zero integer)
- `<input_file>`: Name of the file containing URLs (one per line)

Example:
```
java Main ut 5 urls.txt
```

## Project Structure
- `src/CrawlerSystem/`: Main package containing all system components
  - `Constants/`: Contains constant values and error messages
  - `HttpConnection/`: Manages HTTP connections
  - `InputSource/`: Handles different input sources
  - `Processors/`: Contains resource processors
  - `ResultFormat/`: Manages output formatting

## Design Patterns Implemented

### 1. Factory Pattern (InputSourceFactory)
- **Problem Solved**: Enables reading input from different sources (e.g., file, terminal).
- **Implementation**: Factory creates correct object based on input type enum.

### 2. Factory Pattern (ProcessorFactory)
- **Problem Solved**: Allows processing of different resource types (not just images).
- **Implementation**: Creates processor objects based on MIME type.

### 3. Factory Pattern (FormatFactory)
- **Problem Solved**: Handles various output information types.
- **Implementation**: Creates formatting objects based on specified format type.

### 4. Decorator Pattern (FormatDecorator)
- **Problem Solved**: Provides flexible output formatting for additional types of information.
- **Implementation**: Decorators for each format type, combinable for complex outputs.

### 5. Singleton Pattern (ThreadSafeMap)
- **Problem Solved**: Optimizes memory usage in multi-threaded environment.
- **Implementation**: Single instance of ThreadSafeMap used by all threads to store results.

## Extensibility
- To add new input types: Extend `InputSource` and update `InputSourceFactory`.
- For new processors: Implement `Processor` interface and update `ProcessorFactory`.
- To add new output formats: Create new decorator classes and update `FormatFactory`.

## Error Handling
- Malformed URLs: Outputs "malformed" to System.err
- Unreachable URLs: Outputs "failed" to System.err
- Invalid arguments: Displays usage message and exits

## Dependencies
- Java SE (version specified in your project settings)

## Author
- David Zaydenberg, Davidzay@edu.hac.ac.il
- Ron Elian, Ronel@edu.hac.ac.il
