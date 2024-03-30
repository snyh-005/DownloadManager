package org.github.snyh005.facade.impl;

import lombok.extern.slf4j.Slf4j;
import org.github.snyh005.facade.DownloadFacade;
import org.github.snyh005.service.Downloader;
import org.github.snyh005.validator.UrlValidator;
import org.github.snyh005.utils.DownloadUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service("downloadFacade")
public class DownloadFacadeImpl implements DownloadFacade {

    private final Downloader downloader;

    public DownloadFacadeImpl(Downloader downloader) {
        this.downloader = downloader;
    }

    @Override
    public void download(List<String> urls) throws InterruptedException {
        urls.stream().filter(UrlValidator::isValid).collect(Collectors.toList());
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        urls.forEach(url -> executor.execute(() ->{
            downloader.download(url);
        }));
        executor.shutdown();
    }
}
