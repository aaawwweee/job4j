package tracker;

import java.util.function.Consumer;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class FindItemById extends BaseAction {
    private String nextLine = System.lineSeparator();

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("---------- Find Item by ID ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("Item's ID: " + item.getId() + nextLine + "Item's Name: " + item.getName()
                    + nextLine + "Item's description: " + item.getDesc());
        } else {
            output.accept("Item not found.");
        }
    }
}