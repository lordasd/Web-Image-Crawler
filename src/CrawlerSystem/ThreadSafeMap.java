package CrawlerSystem;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ThreadSafeMap class to store the results in a thread-safe map.
 */
public class ThreadSafeMap {
    private static ThreadSafeMap instance;
    private final ConcurrentHashMap<Integer, String> map;
    private final CopyOnWriteArrayList<Integer> indexes;

    /**
     * Constructor to initialize the ThreadSafeMap.
     */
    private ThreadSafeMap() {
        this.map = new ConcurrentHashMap<>();
        this.indexes = new CopyOnWriteArrayList<>();
    }

    /**
     * Method to get the instance of the ThreadSafeMap.
     * @return instance
     */
    public static synchronized ThreadSafeMap getInstance() {
        if (instance == null) {
            instance = new ThreadSafeMap();
        }
        return instance;
    }

    /**
     * Method to put the result in the map.
     * @param index Map index
     * @param result Result to be stored
     */
    public synchronized void put(int index, String result) {
        map.put(index, result);
        indexes.add(index);
    }

    /**
     * Method to print the items in order.
     */
    public void printItemsInOrder() {
        for (int index : indexes) {
            System.out.println(map.get(index));
        }
    }
}