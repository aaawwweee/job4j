package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class FindItemByName implements UserAction {
    private String nextLine = System.lineSeparator();
    public int key() {
        return 5;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find Item by Name ----------");
        String name = input.ask("Please, enter the Item's Name: ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + nextLine + "Item's Name: " + item.getName()
                    + nextLine + "Item's description: " + item.getDesc());
        }
    }
    public String info() {
        return "5. Find Item by Name.";
    }
}
