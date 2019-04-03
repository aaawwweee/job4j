package tracker;

import java.util.*;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 16.03.2019
 * @version 1
 */

public class Tracker {
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(this.position, item);
        position++;
        return item;
    }

    /**
     * @param id - id
     * @param item - item
     * @return - replaced item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                item.setId(id);
                items.set(i, item);
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
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId() != null && this.items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return all items
     */
    public List <Item> findAll() {
        return items;
    }

    /**
     * @param key - key
     * @return copy of array with needed items
     */
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item.getName() != null && item.getName().equals(key)) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * @param id - id
     * @return - array with needed id
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != position; index++) {
            if (items.get(index) != null && items.get(index).getId().equals(id)) {
                result = items.get(index);
                break;
            }
        }
        return result;
    }
}