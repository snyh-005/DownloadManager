package org.github.snyh005.facade;

import org.github.snyh005.facade.impl.DownloadFacadeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(
        MockitoExtension.class
)
public class DownloadFacadeImplTests {

    @InjectMocks
    DownloadFacadeImpl downloadFacade;

    static List<String> urls = new ArrayList<>();

    @BeforeAll
    public static void setup(){
        urls.add("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
        urls.add("http://not-a-valid-url");
    }


    @Test
    public void download() throws InterruptedException {
        downloadFacade.download(urls);
    }
}
