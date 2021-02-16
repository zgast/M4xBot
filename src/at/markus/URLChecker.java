package at.markus;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLChecker {
    public boolean checkURL(String message){
        URLConnection connection = null;
        try {
            connection = new URL(message).openConnection();
            String contentType = connection.getHeaderField("Content-Type");
            return contentType.startsWith("image/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
