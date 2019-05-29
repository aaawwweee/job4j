package list;
/**
 * Queue based on 2 stacks
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 29.05.2019
 * @param <E> generic
 */
public class SimpleQueue<E> {
    private SimpleStack<E> inbox = new SimpleStack<E>();
    private SimpleStack<E> outbox = new SimpleStack<E>();

    public void push(E item) {
        inbox.push(item);
    }

    public E poll() {
        if (outbox.getSize() == 0) {
            while (inbox.getSize() != 0) {
                outbox.push(inbox.poll());
            }
        }
        return outbox.poll();
    }
}