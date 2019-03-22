package tracker;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public MenuTracker(){}

    public int getActionsLength() {
        return this.actions.size();
    }
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add Item."));
        this.actions.add(new ShowAllItems(1, "Show all Items."));
        this.actions.add(new EditItem(2, "Edit Item."));
        this.actions.add(new DeleteItem(3, "Delete Item."));
        this.actions.add(new FindItemById(4, "Find Item by ID."));
        this.actions.add(new FindItemByName(5, "Find Item by Name."));
        this.actions.add(new ExitTracker(6, "Exit.", ui));
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}