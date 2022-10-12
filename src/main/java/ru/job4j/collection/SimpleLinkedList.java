package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int modCount;
    private int size;

    @Override
    public void add(E value) {
        if (size == 0) {
            last = new Node<>(value);
            first = last;
        } else {
            Node<E> newNode = new Node<>(value);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int point = 0;
            private int expectedModCount = modCount;

            private Node<E> current;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (current == null) {
                    current = first;
                } else {
                    current = current.next;
                }
                point++;
                return current.element;
            }
        };
    }

    class Node<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
