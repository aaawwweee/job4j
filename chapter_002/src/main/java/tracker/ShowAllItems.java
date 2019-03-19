package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class ShowAllItems implements UserAction {
    private String nextLine = System.lineSeparator();
    @Override
    public int key() {
        return 1;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Show all Items ----------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + nextLine + "Item's Name: " + item.getName()
                    + nextLine + "Item's description: " + item.getDesc());
        }
    }
    @Override
    public String info() {
        return "1. Show All Items.";
    }
}