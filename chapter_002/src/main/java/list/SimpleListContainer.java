package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 27.05.2019
 * @version 1
 * @param <E> - generic
 */
public class SimpleListContainer<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount = 0;

    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        if (first == null) {
            first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        this.size++;
        modCount++;
    }
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result =  result.next;
        }
        return result.value;
    }
    public int getSize() {
        return this.size;
    }
    public void removeLast() {
        this.last = this.last.previous;
        if (this.last == null) {
            this.last = this.first;
        }
        this.last.next = null;
        this.size--;
        modCount++;
    }
    public void removeFirst() {
        this.first = this.first.next;
        if (this.first == null) {
            this.first = this.last;
        }
        this.first.next = null;
        this.size--;
        modCount++;
    }
    public E getFirst() {
        E value = this.first.value;
        return value;
    }
    public E getLast() {
        E value = this.last.value;
        return value;
    }
    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;
        public Node(E value) {
            this.value = value;
        }

    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> position = first;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return position != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = position.value;
                position = position.next;
                return value;
            }
        };
    }
}