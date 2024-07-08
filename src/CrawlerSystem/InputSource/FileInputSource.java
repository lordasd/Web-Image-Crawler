package CrawlerSystem.InputSource;

import CrawlerSystem.Constants.ErrorMessages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents a file input source.
 * It reads from a file.
 */
public class FileInputSource implements InputSource {
    private final BufferedReader reader;

    /**
     * Constructs a file input source.
     * @param filename the name of the file to read from
     */
    public FileInputSource(String filename) {
        BufferedReader tempReader;
        try {
            tempReader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            throw new RuntimeException(ErrorMessages.OPEN_FILE_ERROR + filename, e);
        }
        this.reader = tempReader;
    }

    /**
     * Reads a line from the file.
     * @return the line read
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }

    /**
     * Closes the file.
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }
}