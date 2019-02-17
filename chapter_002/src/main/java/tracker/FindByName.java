package tracker;

public class FindByName implements UserAction {
    public int key() {
        return 5;
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
    public String info() {
        return String.format("%s. %s", this.key(), "Find Item by Name");
    }
}