package solvd.training.student.customlinkedlist;

import java.util.Objects;

public class CustomLinkedList<T> {

    private Node<T> head;
    private int size;

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

    public void remove(int index) {
        checkIndexBounds(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
        }
        size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        return sb.toString();
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

    private static class Node<T> {
        final T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
