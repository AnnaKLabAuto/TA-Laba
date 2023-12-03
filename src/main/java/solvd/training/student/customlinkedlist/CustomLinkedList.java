package solvd.training.student.customlinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private int size;

    private static class Node<T> {
        final T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        Objects.requireNonNull(data, "Data cannot be null");
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T get(int index) {
        checkIndexBounds(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }



    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public int indexOf(T employee) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (Objects.equals(current.data, employee)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T data) {
        if (!contains(data)) {
            throw new NoSuchElementException("Element not found in the list");
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }

            size--;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = (T) current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };

    }
}