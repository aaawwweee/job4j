package map;
import java.util.*;

/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @since 09/06/19
 * @version 1
 * @param <K> key
 * @param <V> value
 */
public class HashMap<K, V> implements Iterable {
    private int modCount = 0;
    private Node<K, V>[] table;
    private int size = 0;
    private float threshold;
    private final float loadFactor = 0.75f;
    public HashMap() {
        this.table = new Node[10];
        this.threshold = loadFactor * table.length;
    }
    boolean insert(K key, V value) {
        if (size >= threshold) {
            threshold *= 2;
            this.increaseSize();
        }
        boolean result = false;
        Node<K, V> node = new Node<>(key, value);
        int index = this.indexFor(key);
        if (this.table[index] == null || (this.table[index] != null && this.table[index].getKey().equals(key))) {
            this.table[index] = new Node<>(key, value);
            this.size++;
            this.modCount++;
            result = true;
        }
        return result;
    }
    private void increaseSize() {
        Node<K, V>[] oldTable = this.table;
        this.table = new Node[oldTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                this.insert(node.key, node.value);
            }
        }
    }
    V get(K key) {
        int index = this.indexFor(key);
        return this.table[index] != null && this.table[index].getKey().equals(key) ? this.table[index].getValue() : null;
    }

    boolean delete(K key) {
        boolean result = false;
        int index = this.indexFor(key);
        if (this.table[index].getKey().equals(key)) {
            this.table[index] = null;
            result = true;
            this.size--;
            this.modCount++;
        }
        return result;
    }

    public int indexFor(K key) {
        return key.hashCode() % table.length;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            final int expectedModCount = modCount;
            int itIndex = 0;
            @Override
            public boolean hasNext() {
                checkForComodification();
                boolean result = false;
                for (int i = itIndex; i < table.length; i++) {
                    if (table[i] != null) {
                        itIndex = i;
                        result = true;
                        break;
                    }
                }
                return result;
            }
            @Override
            public V next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node result = table[itIndex++];
                return (V) result.value;
            }
            void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
