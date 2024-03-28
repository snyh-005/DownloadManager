package org.github.validator;

import lombok.extern.slf4j.Slf4j;
import org.github.event.publisher.UpdateProgressEventPublisher;
import org.github.utils.DownloadUtils;
import org.github.utils.ProgressManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DownloadUtilsTests {

    static final String VALID_URL = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
    static final String INVALID_URL = "http://not-a-valid-url";

    @Mock
    UpdateProgressEventPublisher updateProgressEventPublisher;

    @Test
    public void testDownload() throws IOException {
        DownloadUtils.download(VALID_URL);
        Map<String, Double> progress = ProgressManager.getInstance().getProgress();
        assertEquals(1, progress.size());
    }

    @Test
    public void testDownload_InvalidUrl() {
        try {
            DownloadUtils.download(INVALID_URL);
        } catch (Exception e) {
            assertEquals("not-a-valid-url", e.getMessage());
        }
    }
}
