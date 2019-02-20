package tracker;
import java.util.List;
import java.util.ArrayList;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowAllItems(1, "Show all Items"));
        this.actions.add(new EditItem(2, "Edit Item"));
        this.actions.add(new DeleteItem(3, "Delete Item"));
        this.actions.add(new FindById(4, "Find Item by ID"));
        this.actions.add(new FindByName(5, "Find Item by Name"));
        this.actions.add(new ExitProgram(6, "Exit Program", ui));
    }
    public MenuTracker() {
    }

    public int getActionsLength() {
        return this.actions.size();
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
