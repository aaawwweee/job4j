package tree;
import java.util.Optional;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 12.06.2019
 * @version 1
 * @param <E> - generic
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}