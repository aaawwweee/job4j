package tracker;

public class ExitProgram implements UserAction {
    private final StartUI ui;
     ExitProgram(StartUI ui) {
         this.ui = ui;
     }
    @Override
    public int key() {
        return 6;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("You have chosen item 6 - Exit. GoodBye!");
        this.ui.stop();
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program");
    }
}