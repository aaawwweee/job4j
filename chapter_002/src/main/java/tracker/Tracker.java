package tracker;

import java.util.*;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 02.02.2019
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * generation random ID
     * @return id
     */
    private String generateId() {
        String id = String.valueOf(System.currentTimeMillis() + RN.nextInt());
        return id;
    }
    /**
     * @param item - new request
     * @return - item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * @param id - existing id
     * @param item - existing request for substitution
     * @return - new request
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * @param id - existing id
     * @return - new array without 1 request
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position - 1 - i);
                result = true;
                break;
            }
            i++;
        }
        return result;
    }
    /**
     * @return - copy of the requests
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * @param key - key to find request
     * @return - request
     */
    public Item[] findByName(String key) {
        int x = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            if ((this.items[i] != null) && (this.items[i].getName().equals(key))) {
                result[x] = items[i];
                x++;
            }
        }
        return Arrays.copyOf(result, x);
    }
    /**
     * @param id - existing id
     * @return - request
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}
