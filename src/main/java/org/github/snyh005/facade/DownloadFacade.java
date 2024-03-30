package org.github.snyh005.facade;

import java.util.List;

public interface DownloadFacade {

    void download(List<String> urls) throws InterruptedException;
}
