package CrawlerSystem.HttpConnection;

import CrawlerSystem.Constants.ErrorMessages;
import CrawlerSystem.Constants.HttpConstants;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * GetHttpConnection class is responsible for making a GET request to the given URL.
 */
public class GetHttpConnection implements HttpConnection {
    private HttpURLConnection connection;
    private long responseTime;

    /**
     * This method is responsible for making a GET request to the given URL.
     * @param url URL to which the GET request is to be made.
     * @throws Exception If the URL is malformed or unreachable.
     */
    @Override
    public void connect(String url) throws Exception {
        try {
            long startTime = System.currentTimeMillis();

            this.connection = (HttpURLConnection) new URI(url).toURL().openConnection();
            this.connection.setRequestMethod(HttpConstants.HTTP_METHOD_GET);
            this.connection.connect();

            long endTime = System.currentTimeMillis();
            responseTime = endTime - startTime;
        } catch (MalformedURLException | URISyntaxException e) {
            throw new MalformedURLException(ErrorMessages.URL_MALFORMED_ERROR + url);
        } catch (IOException e) {
            throw new IOException(ErrorMessages.URL_UNREACHABLE_ERROR + url);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.URI_ABSOLUTE_ERROR + url, e);
        }
    }

    /**
     * This method is responsible for getting the content type of the response.
     * @return Content type of the response.
     */
    @Override
    public String getContentType() {

        if (this.connection != null) {
            String contentType = this.connection.getContentType();
            if (contentType != null)
                return contentType.split(";")[0];
        }

        throw new NullPointerException(ErrorMessages.CONTENT_MISSING_ERROR);
    }

    /**
     * This method is responsible for getting the content length of the response.
     * @return Content length of the response.
     */
    @Override
    public int getContentLength() {
        if (this.connection != null)
            return this.connection.getContentLength();
        return -1;
    }

    /**
     * This method is responsible for getting the response code of the response.
     * @return Url of the response.
     */
    @Override
    public String getURL() {
        if (this.connection != null)
            return this.connection.getURL().toString();
        return null;
    }

    /**
     * This method is responsible for getting the response code of the response.
     */
    @Override
    public void disconnect() {
        if (this.connection != null)
            this.connection.disconnect();
    }

    /**
     * This method is responsible for getting the response code of the response.
     * @return Response time
     */
    @Override
    public long getResponseTime() {
        return responseTime;
    }
}
