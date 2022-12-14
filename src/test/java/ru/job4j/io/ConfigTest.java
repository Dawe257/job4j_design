package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithCommentAndEmptyLines() {
        String path = "./data/with_comment_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres");
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password");
    }

    @Test
    void whenPairWithInvalid() {
        String path = "./data/with_invalid_line.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Property does not have a separator:");
    }

    @Test
    void whenPairWithInvalidKey() {
        String path = "./data/with_invalid_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid property: key=");
    }

    @Test
    void whenPairWithInvalidValue() {
        String path = "./data/with_invalid_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid property: =value");
    }

    @Test
    void whenPairWithMultipleSeparator() {
        String path = "./data/with_multiple_separator.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=value");
    }
}