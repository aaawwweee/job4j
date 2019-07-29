package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Entry point to the program
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 17.03.2019
 */
public class StartUI {
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(), System.out::println
        ).init();
    }
    private final ITracker tracker;
    private final Input input;
    private final Consumer<String> output;

    private boolean working = true;

    public void stop() {
        this.working = false;
    }

    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0;  i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select:", range));
        } while (this.working);
    }
}