package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MaxMinTest {

    private static MaxMin maxMin;
    private static Comparator<Integer> comparator;

    @BeforeAll
    static void setUp() {
        maxMin = new MaxMin();
        comparator = Comparator.comparingInt(n -> n);
    }

    @Test
    void max() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer expected = 5;
        Integer actual = maxMin.max(list, comparator);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void min() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Integer expected = 1;
        Integer actual = maxMin.min(list, comparator);
        assertThat(actual).isEqualTo(expected);
    }
}