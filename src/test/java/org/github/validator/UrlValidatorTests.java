package org.github.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrlValidatorTests {
    static final String VALID_URL = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
    static final String INVALID_URL = "http://not-a-valid-url";

    @Test
    public void testIsValid() {
        assertTrue(UrlValidator.isValid(VALID_URL));
    }

    @Test
    public void testIsValid_Invalid() {
        assertFalse(UrlValidator.isValid(INVALID_URL));
    }
}
