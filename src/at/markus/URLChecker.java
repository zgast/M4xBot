package at.markus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLChecker {
    public boolean checkURL(String message){
        URLConnection connection = null;
        if(getFileSize(message)<30000000){
            try {
                connection = new URL(message).openConnection();
                String contentType = connection.getHeaderField("Content-Type");
                return contentType.startsWith("image/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public long getFileSize(String url) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            return conn.getContentLengthLong();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
