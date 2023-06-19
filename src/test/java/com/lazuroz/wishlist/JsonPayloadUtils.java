package com.lazuroz.wishlist;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonPayloadUtils {
    public static String getJsonPayload(String jsonPath) {
        try (InputStream fis = JsonPayloadUtils.class.getClassLoader().getResourceAsStream(jsonPath)) {
            if (fis != null) {
                return IOUtils.toString(fis, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Error loading payload from: " + jsonPath);
    }
}
