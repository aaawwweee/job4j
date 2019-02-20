package tracker;

public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("Item's ID: " + item.getId() + " " + "Item's Name: " + item.getName() + " Item's description: " + item.getDesc());
        }
    }
}
