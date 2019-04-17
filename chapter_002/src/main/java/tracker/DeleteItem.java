package tracker;

import java.util.function.Consumer;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("---------- Delete the Item ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        boolean x = tracker.delete(id);
        if (x) {
            output.accept("The Item has been deleted");
        } else {
            output.accept("The Item hasn't been deleted");
        }
    }
}