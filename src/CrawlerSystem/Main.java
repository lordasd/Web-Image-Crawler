package CrawlerSystem;


import CrawlerSystem.Constants.ErrorMessages;
import CrawlerSystem.InputSource.InputType;

/**
 * Main class to start the Crawler System.
 */
public class Main {
    /**
     * Main method to start the Crawler System.
     * @param args format poolSize source
     */
    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException(ErrorMessages.USAGE_MESSAGE);
            }

            String format = args[0];
            int poolSize = Integer.parseInt(args[1]);
            if (poolSize <= 0) {
                throw new IllegalArgumentException(ErrorMessages.POOL_SIZE_ERROR);
            }

            Crawler crawler = new Crawler(format, poolSize, args[2], InputType.FILE);
            crawler.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}