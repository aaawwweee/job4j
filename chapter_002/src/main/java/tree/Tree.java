package tree;
import java.util.*;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 12.06.2019
 * @version 1
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E>{
    Node <E> root;

    public Tree(E value) {
        this.root = new Node(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result =  false;
        Optional<Node<E>> checkParent = findBy(parent);
        Optional<Node<E>> checkChild = findBy(child);
        if (checkParent.isPresent() && checkChild.isEmpty()) {
            checkParent.get().add(new Node<>(child));
            result = true;
        } else if (checkParent.isEmpty()) {
            throw new NoSuchElementException("The specified parent is not exists.");
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> elements = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }

            @Override
            public E next() {
                Node<E> res = this.elements.poll();
                elements.addAll(res.leaves());
                return res.getValue();
            }
        };

    }

    private boolean isBinary(Node<E> node) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(node);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                return false;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return true;
    }

    public boolean isBinary() {
        return isBinary(this.root);
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();//rsl - optional instance
        Queue<Node<E>> data = new LinkedList<>();//создаем очередь data
        data.offer(this.root);//до
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

}
