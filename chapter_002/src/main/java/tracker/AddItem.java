package tracker;

import java.util.function.Consumer;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("---------- Adding a new Item ----------");
        String name = input.ask("Please, think up with the name of the Item: ");
        String desc = input.ask("Add description: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("---------- New Item's ID: " + item.getId() + " ----------");
    }
}
