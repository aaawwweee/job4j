package tracker;

public class FindById extends BaseAction {
    public FindById(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find Item by ID ----------");
        String id = input.ask("Please, provide Item's ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println("Item's ID: " + foundItem.getId() + " Item's Name: " + foundItem.getName() + " Item's description: " + foundItem.getDesc());
        } else {
            System.out.println("---------- Item is not found ---------- ");
        }
    }
}