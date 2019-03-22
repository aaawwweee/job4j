package tracker;

public class ExitTracker extends BaseAction {

    private final StartUI ui;

    ExitTracker(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Have a nice day. Goodbye.");
        this.ui.stop();
    }
}