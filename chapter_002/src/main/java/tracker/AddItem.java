package tracker;

public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Adding new Item ----------");
        String name = input.ask("Please, provide Item's name:");
        String desc = input.ask("Please, provide Item's description:");
        Item item = new Item(name, desc, 123123L);
        tracker.add(item);
        System.out.println("---------- New Item with ID: " + item.getId());
        System.out.println("---------- New Item with Name: " + item.getName());
        System.out.println("---------- New Item with Description: " + item.getDesc());
    }
}