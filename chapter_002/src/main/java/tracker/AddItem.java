package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class AddItem implements UserAction {
    public int key() {
        return 0;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Adding a new Item ----------");
        String name = input.ask("Please, think up with the name of the Item: ");
        String desc = input.ask("Add description: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("---------- New Item's ID: " + item.getId() + " ----------");
    }
    public String info() {
        return "0. Add Item.";
    }
}
