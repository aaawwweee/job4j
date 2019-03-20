package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point to the program
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 17.03.2019
 */
public class StartUI {
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
    }
    private final Tracker tracker;
    private final Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0;  i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
}