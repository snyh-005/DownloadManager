package org.github.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtils {
    public static void download(String url) throws IOException {
        URL website = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();
        connection.connect();

        String fileName = UrlUtils.extractFileName(url);
        long fileSize = connection.getContentLengthLong();

        download(website.openStream(), fileName, fileSize);
    }

    private static void download(InputStream inputStream, String fileName, long fileSize) throws IOException {
        byte[] buffer = new byte[4096];
        long downloaded = 0;
        int bytesRead;
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
                downloaded += bytesRead;
                getDownloadProgress(fileName, fileSize, downloaded);
            }
            ProgressManager.getInstance().updateProgress(fileName, 100.0);
        }
    }

    private static void getDownloadProgress(String fileName, long fileSize, long downloaded) {
        double progress = (double) downloaded / fileSize * 100;
        ProgressManager.getInstance().updateProgress(fileName, progress);
    }
}
