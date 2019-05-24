package list;

import java.util.NoSuchElementException;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 23.05.2019
 * @version 1
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    public E delete(){
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E result = this.first.data;
        this.first = this.first.next;
        first.next = null;
        this.size--;
        return result;
    }
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
    public int getSize() {
        return this.size;
    }
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }
}