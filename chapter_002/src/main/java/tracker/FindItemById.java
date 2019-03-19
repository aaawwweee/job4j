package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class FindItemById implements UserAction {
    private String nextLine = System.lineSeparator();
    public int key() {
        return 4;
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find Item by ID ----------");
        String id = input.ask("Please, enter the Item's ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item's ID: " + item.getId() + nextLine + "Item's Name: " + item.getName()
                    + nextLine + "Item's description: " + item.getDesc());
        } else {
            System.out.println("Item not found.");
        }
    }
    public String info() {
        return "4. Find Item by ID.";
    }
}