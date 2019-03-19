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
    public int getActionsLength() {
        return this.actions.size();
    }
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemByName());
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