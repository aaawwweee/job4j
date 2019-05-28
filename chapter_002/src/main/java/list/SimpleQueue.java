package list;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 28.05.2019
 * @param <E>
 */
public class SimpleQueue<E> {
    SimpleListContainer<E> queueContainer;

    public SimpleQueue() {
        this.queueContainer = new SimpleListContainer<>();
    }

    public void push(E value) {
        queueContainer.add(value);
    }

    public E poll() {
        E item = queueContainer.getFirst();
        queueContainer.removeFirst();
        return item;
    }
}