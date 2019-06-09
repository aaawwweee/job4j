package map;
import java.util.*;

/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @since 09/06/19
 * @version 1
 * @param <K> key
 * @param <V> value
 */
public class HashMap<K,V> implements Iterable{
    private int modCount = 0;
    private Node<K,V>[] table;
    private int size = 0;
    private float threshold;
    private final float loadFactor = 0.75f;
    public HashMap() {
        this.table = new Node[10];
        this.threshold = loadFactor * table.length;
    }
    boolean insert(K key, V value){
        boolean result;
        if (size >= threshold) {
            threshold *= 2;
            this.increaseSize();
        }
        Node<K,V> node = new Node<>(key, value);
        int index = this.hash(key);
        if (this.table[index] != null) {
            result = false;
        } else {
            this.table[index] = node;
            result = true;
        }
        size++;
        modCount++;
        return result;
    }
    private void increaseSize() {
        Node<K,V>[] oldTable = this.table;
        this.table = new Node[oldTable.length * 2];
        size = 0;
        for (Node<K,V> node : oldTable) {
            if (node != null) {
                this.insert(node.key, node.value);
            }
        }
    }
    V get(K key) {
        V result = null;
        int index = this.hash(key);
        if (this.table[index]!= null) {
            Node<K,V> current = this.table[index];
            result = current.value;
        }
        return result;
    }

    boolean delete(K key){
        boolean result = false;
        int index = this.hash(key);
        if (this.table[index] != null) {
            this.table[index] = null;
            result = true;
        }
        size--;
        modCount++;
        return result;
    }

    public int hash(K key) {
        return key.hashCode() % table.length;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int current = -1;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return current < table.length;
            }

            @Override
            public K next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                current++;
                while (table[current] == null) {
                    current++;
                }
                return table[current].key;
            }
        };
    }

    static class Node<K,V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
