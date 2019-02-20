package tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;

     ExitProgram(int key, String name, StartUI ui) {
         super(key, name);
         this.ui = ui;
     }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("You have chosen item 6 - Exit. GoodBye!");
        this.ui.stop();
    }
}