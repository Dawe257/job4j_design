package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private final Properties properties = new Properties();

    public PropertiesUtil() {
        loadProperties();
    }

    public Properties getProperties() {
        return properties;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try (InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}