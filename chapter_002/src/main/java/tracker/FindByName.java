package tracker;

public class FindByName implements UserAction {
    public int key() {
        return 5;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find Item by Name ----------");
        String name = input.ask("Please, provide Name's ID: ");
        Item [] foundItemName = tracker.findByName(name);
        if (foundItemName.length > 0) {
            for (Item x : foundItemName) {
                System.out.println("---------- Item found  " + x + " ");
            }
        } else {
            System.out.println("---------- Item is not found ---------- ");
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Find Item by Name");
    }
}
