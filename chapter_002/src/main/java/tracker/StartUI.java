package tracker;

public class StartUI {
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
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
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select:")));
        } while (this.working);
        }
    }