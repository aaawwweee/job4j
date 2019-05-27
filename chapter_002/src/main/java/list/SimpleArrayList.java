package list;

import java.util.NoSuchElementException;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 23.05.2019
 * @version 1
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> tail;
    private Node<E> head;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        if (head == null) {
            head = newLink;
            tail = newLink;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
        this.size++;
    }
    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> result = head;
        head = head.next;
        head.next = null;
        this.size--;
        return result.data;
    }
    public E deleteTail() {
        Node<E> result = tail;
        tail = tail.previous;
        tail.previous = null;
        this.size--;
        return result.data;
    }
    public E get(int index) {
        Node<E> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
    public int getSize() {
        return this.size;
    }
    @Override
    public String toString() {
        return "LinkedList [head=" + head + "]";
    }
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;
        Node(E data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }
    }
}