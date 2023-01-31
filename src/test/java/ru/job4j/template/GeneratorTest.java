package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class GeneratorTest {

    private Generator generator;

    @Test
    void produce() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        String expected = "I am a Petr Arsentev, Who are you?";
        String actual = generator.produce(template, args);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWithWrongGeyInTemplate() {
        String template = "I am a ${name}, Who ${wrongKey} are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, args));
    }

    @Test
    void shouldThrowExceptionWithWrongGeyInArgs() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you", "wrongKey", "");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, args));
    }
}