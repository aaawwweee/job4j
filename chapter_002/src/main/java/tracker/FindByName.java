package tracker;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find Item by Name ----------");
        String name = input.ask("Please, provide Item's Name: ");
        Item[] foundItemName = tracker.findByName(name);
        if (foundItemName.length > 0) {
            for (Item x : foundItemName) {
                System.out.println("Item found. Item's ID: " + x.getId() + " Item's Name: " + x.getName() + " Item's description: " + x.getDesc());
            }
        } else {
            System.out.println("---------- Item is not found ---------- ");
        }
    }
}