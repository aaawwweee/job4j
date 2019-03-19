package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class EditItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Edit the Item ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        String name = input.ask("Enter the Item's Name: ");
        String desc = input.ask("Enter the Item's description: ");
        Item item = new Item(name, desc);
        boolean x = tracker.replace(id, item);
        if (x) {
            System.out.println("The Item has been edited");
        } else {
            System.out.println("The Item hasn't been edited");
        }
    }
    public String info() {
        return "2. Edit Item.";
    }
}
