package tracker;

import java.util.function.Consumer;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, ITracker tracker, Consumer<String> output) {
        output.accept("---------- Edit the Item ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        String name = input.ask("Enter the Item's Name: ");
        String desc = input.ask("Enter the Item's description: ");
        Item item = new Item(name, desc);
        boolean x = tracker.replace(id, item);
        if (x) {
            output.accept("The Item has been edited");
        } else {
            output.accept("The Item hasn't been edited");
        }
    }
}
