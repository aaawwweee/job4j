package tracker;

public class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Edit Item ----------");
        String id = input.ask("Please, provide Item's ID: ");
        String name = input.ask("Please, provide Item's name:");
        String desc = input.ask("Please, provide Item's description:");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("---------- Item is replaced ----------");
        } else {
            System.out.println("---------- Item is not replaced");
        }
    }
}