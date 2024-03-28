package org.github.service;

import java.util.List;

public interface DownloadService {

    void download(List<String> urls) throws InterruptedException;
}
