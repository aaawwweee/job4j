package tracker;
import java.util.*;
public class StartUI {
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
    MenuTracker menuTracker = new MenuTracker();
    private int range = menuTracker.getActionsLength();
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;

    public void stop() {
        this.working = false;
    }
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select:", range));
        } while (this.working);
        }
    }