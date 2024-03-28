package org.github.validator;


public class UrlValidator {
    public static boolean isValid(String url) {
        // Regex to check valid URL format (can be adjusted for specific needs)
        String regex = "^(https?://)?[^\\s]+?\\.(?:zip|pdf|docx|xlsx|pptx|mp3|jpg|png|gif|mp4|exe|iso|dmg)$";
        return url != null && url.matches(regex);
    }
}
