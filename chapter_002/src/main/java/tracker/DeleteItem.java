package tracker;
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
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Delete the Item ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        boolean x = tracker.delete(id);
        if (x) {
            System.out.println("The Item has been deleted");
        } else {
            System.out.println("The Item hasn't been deleted");
        }
    }
}