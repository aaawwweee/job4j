package tracker;

import java.util.function.Consumer;

public class ExitTracker extends BaseAction {

    private final StartUI ui;

    ExitTracker(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, ITracker tracker, Consumer<String> output) {
        output.accept("Have a nice day. Goodbye.");
        this.ui.stop();
    }
}