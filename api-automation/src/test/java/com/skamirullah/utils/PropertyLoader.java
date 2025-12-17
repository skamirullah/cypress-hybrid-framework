package com.skamirullah.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public static Properties load(String fileName) {
        Properties props = new Properties();
        try (InputStream is =
                PropertyLoader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }
            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
        return props;
    }
}

