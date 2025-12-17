package com.skamirullah.config;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class EnvConfig {

    private static final String ENV =
            System.getProperty("env", "qa");

    private static JSONObject config;

    static {
        try {
            String content = Files.readString(
                Paths.get("../config/env-config.json")
            );
            config = new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load env config", e);
        }
    }

    public static String getApiBaseUrl() {
        return config.getJSONObject(ENV)
                     .getJSONObject("api")
                     .getString("baseUrl");
    }
}

