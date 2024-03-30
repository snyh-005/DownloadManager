package org.github.snyh005.utils;

public class UrlUtils {

    public static String extractFileName(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
