package org.github.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.github.service.DownloadService;
import org.github.utils.DownloadUtils;
import org.github.utils.ProgressManager;
import org.github.validator.UrlValidator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {
    @Override
    public void download(List<String> urls) throws InterruptedException {

        urls.stream().filter(UrlValidator::isValid).collect(Collectors.toList());

        Thread [] threads = new Thread[urls.size()];
        int i=0;
        for(String url: urls){
            threads[i] = new Thread(() ->{
                try {
                    DownloadUtils.download(url);
                } catch (IOException e) {
                    // logging the error as download error shouldn't be
                    // failing the rest of the thread.
                    log.warn("Error downloading the file");
                }
            });
            i++;
        }

        for(Thread thread: threads) {
            thread.start();
        }

//        for(Thread thread: threads) {
//            thread.join();
//        }
    }
}
