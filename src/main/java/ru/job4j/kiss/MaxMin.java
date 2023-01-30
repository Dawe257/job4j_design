package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        List<T> sorted = sort(value, comparator);
        return sorted.get(sorted.size() - 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        List<T> sorted = sort(value, comparator);
        return sorted.get(0);
    }

    private <T> List<T> sort(List<T> value, Comparator<T> comparator) {
        List<T> result = new ArrayList<>(value);
        result.sort(comparator);
        return result;
    }
}
