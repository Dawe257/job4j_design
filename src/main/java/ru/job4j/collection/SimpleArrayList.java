package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    private int index;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(T value) {
        if (index == size) {
            grow();
            size++;
        }
        container[index++] = value;
        modCount++;
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldValue = get(index);
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T element = get(index);
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        size--;
        modCount++;
        return element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[point++];
            }
        };
    }
}