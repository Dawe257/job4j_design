package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (a, b) -> comparator.compare(a, b) > 0;
        return sort(value, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (a, b) -> comparator.compare(a, b) < 0;
        return sort(value, predicate);
    }

    private <T> T sort(List<T> value, BiPredicate<T, T> predicate) {
        T result = value.isEmpty() ? null : value.get(0);
        if (result != null) {
            for (int i = 1; i < value.size(); i++) {
                T current = value.get(i);
                if (predicate.test(current, result)) {
                    result = current;
                }
            }
        }
        return result;
    }
}
