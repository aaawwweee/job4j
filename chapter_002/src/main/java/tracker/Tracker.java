package tracker;

import java.util.*;

/**
 * @author Alexander Kashkin (kasjkinmsk@gmail.com)
 * @since 16.03.2019
 * @version 1
 */

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * generation for id
     * @return random id
     */
    private String generateId() {
       return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * @param item item
     * @return new item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * @param id - id
     * @param item - item
     * @return - replaced item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length - 1; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @param id - id
     * @return - copy of array without deleted item
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.length - 1; i++) {
            if (this.items[i].getId() != null && this.items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return all items
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * @param key - key
     * @return copy of array with needed items
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i != position; i++) {
            if (this.items[i].getName() != null && this.items[i].getName().equals(key)) {
                result[i] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * @param id - id
     * @return - array with needed id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
