package tracker;
/**
 * Entry point to the program
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 17.03.2019
 */
public class StartUI {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
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
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
}