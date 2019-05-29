package list;

/**
 * Simple Stack Container on base of LinkedList
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 27.05.2019
 * @version 1
 * @param <E> - generic
 */

public class SimpleStack<E> {
    SimpleListContainer<E> stackContainer;

    public SimpleStack() {
        this.stackContainer = new SimpleListContainer<>();
    }

    public E poll() {
        E item = stackContainer.getLast();
        stackContainer.removeLast();
        return item;
    }
    public void push(E value) {
        stackContainer.add(value);
    }
}
