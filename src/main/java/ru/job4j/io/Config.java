package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(line -> {
                if (!line.startsWith("#") && !line.isEmpty()) {
                    if (!line.contains("=")) {
                        throw new IllegalArgumentException(String.format("Property does not have a separator: %s", line));
                    }
                    String[] lineArr = line.split("=", 2);
                    String key = lineArr[0];
                    String value = lineArr[1];
                    if ("".equals(key) || "".equals(value)) {
                        throw new IllegalArgumentException(String.format("Invalid property: %s", line));
                    }
                    values.put(key, value);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Config("app.properties"));
//        Config config = new Config("app.properties");
        Config config = new Config("./data/with_comment_and_empty_lines.properties");
        config.load();
        System.out.println(config.value("hibernate.connection.driver_class"));
    }
}