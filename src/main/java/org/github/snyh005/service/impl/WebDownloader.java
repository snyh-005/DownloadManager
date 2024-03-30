package org.github.snyh005.service.impl;

import org.github.snyh005.event.publisher.UpdateProgressEventPublisher;
import org.github.snyh005.service.Downloader;
import org.github.snyh005.utils.DownloadUtils;
import org.github.snyh005.utils.ProgressManager;
import org.github.snyh005.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service("webDownloader")
public class WebDownloader implements Downloader {


    private final UpdateProgressEventPublisher event;

    public WebDownloader(UpdateProgressEventPublisher event) {
        this.event = event;
    }

    @Override
    public void download(String url) {
            String fileName = UrlUtils.extractFileName(url);
            try {
                URL website =   new URI(url).toURL();
                HttpURLConnection connection = (HttpURLConnection) website.openConnection();
                connection.connect();
                long fileSize = connection.getContentLengthLong();
                DownloadUtils.download(website.openStream(), fileName, fileSize);
            }
            catch (IOException | URISyntaxException e){
                ProgressManager.getInstance().updateProgress(fileName, 0.0);
            }
            finally {
                event.publish();
            }
    }
}
