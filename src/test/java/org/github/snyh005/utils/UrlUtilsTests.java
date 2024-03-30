package org.github.snyh005.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlUtilsTests {

    static final String VALID_URL = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";

    static final String FILE_NAME = "c4611_sample_explain.pdf";

    @Test
    public void testExtractFileName(){
        assertEquals(FILE_NAME, UrlUtils.extractFileName(VALID_URL));
    }
}
