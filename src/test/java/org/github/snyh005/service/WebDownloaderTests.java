package org.github.snyh005.service;

import org.github.snyh005.event.publisher.UpdateProgressEventPublisher;
import org.github.snyh005.service.impl.WebDownloader;
import org.github.snyh005.utils.DownloadUtils;
import org.github.snyh005.utils.ProgressManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(
        MockitoExtension.class
)
public class WebDownloaderTests {

    static final String VALID_URL = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
    static final String INVALID_URL = "http://not-a-valid-url";

    @Mock
    UpdateProgressEventPublisher updateProgressEventPublisher;

    @InjectMocks
    WebDownloader webDownloader;

    @Test
    public void testDownload() throws IOException {
        webDownloader.download(VALID_URL);
        ThreadLocal<Map<String, Double>> progress = ProgressManager.getInstance().getProgress();
        assertTrue( progress.get().size()>0);
    }

    @Test
    public void testDownload_InvalidUrl() {
        try {
            webDownloader.download(INVALID_URL);
        } catch (Exception e) {
            assertEquals("not-a-valid-url", e.getMessage());
        }
    }
}
