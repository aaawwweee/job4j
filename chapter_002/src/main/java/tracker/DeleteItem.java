package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class DeleteItem implements UserAction {
    public int key() {
        return 3;
    }
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
    public String info() {
        return "3. Delete Item.";
    }
}