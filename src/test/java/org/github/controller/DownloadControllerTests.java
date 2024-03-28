package org.github.controller;

import org.github.service.DownloadService;
import org.github.service.impl.DownloadServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DownloadControllerTests {

    @Mock
    DownloadServiceImpl downloadService;

    @InjectMocks
    DownloadController downloadController;

    static List<String> urls = new ArrayList<>();

    @BeforeAll
    public static void setup(){
        urls.add("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
        urls.add("http://not-a-valid-url");
    }

    @Test
    public void testDownload() throws InterruptedException {
        ResponseEntity<Map<String, Double>> response = downloadController.download(urls);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
