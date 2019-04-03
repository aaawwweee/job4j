package tracker;

import java.util.List;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class ShowAllItems extends BaseAction {
    private String nextLine = System.lineSeparator();

    public ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Show all Items ----------");
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + nextLine + "Item's Name: " + item.getName()
                    + nextLine + "Item's description: " + item.getDesc());
        }
    }
}