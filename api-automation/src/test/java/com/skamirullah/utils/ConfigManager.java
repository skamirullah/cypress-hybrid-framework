package com.skamirullah.utils;

import java.util.Properties;

public class ConfigManager {

    private static final Properties props =
            PropertyLoader.load("config.properties");

    public static String getBaseUri() {
        return props.getProperty("base.uri");
    }
}
