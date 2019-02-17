package tracker;

public class ShowAllItems implements UserAction {
    @Override
    public int key() {
        return 1;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("Item's ID: " + item.getId() + " " + "Item's Name: " + item.getName() + " Item's description: " + item.getDesc());
        }
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Show all Items");
    }
}
