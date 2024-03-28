package org.github.service;

import org.aspectj.lang.annotation.Before;
import org.github.service.impl.DownloadServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(
        MockitoExtension.class
)
public class DownloadServiceImplTests {

    @InjectMocks
    DownloadServiceImpl downloadService;

    static List<String> urls = new ArrayList<>();

    @BeforeAll
    public static void setup(){
        urls.add("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
        urls.add("http://not-a-valid-url");
    }


    @Test
    public void download() throws InterruptedException {
        downloadService.download(urls);
    }
}
