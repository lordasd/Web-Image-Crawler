package CrawlerSystem.ResultFormat;

/**
 * FormatType enum
 */
public enum FormatType {
    SIZE('s'),
    URL('u'),
    TIME('t'),
    MIME_TYPE('m');

    private final char code;

    /**
     * Constructor
     * @param code char
     */
    FormatType(char code) {
        this.code = code;
    }

    /**
     * Get the code
     * @return char
     */
    public char getCode() {
        return code;
    }
}
