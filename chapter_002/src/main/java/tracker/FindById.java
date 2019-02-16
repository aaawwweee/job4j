package tracker;

public class FindById implements UserAction {
    public int key() {
        return 4;
    }
    public void execute(Input input, Tracker tracker){
        System.out.println("---------- Find Item by ID ----------");
        String id = input.ask("Please, provide Item's ID: ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println("---------- Item found  " + foundItem + " ");
        } else {
            System.out.println("---------- Item is not found ---------- ");
        }

    }
    public String info(){
        return String.format("%s. %s", this.key(), "Find Item by ID");
    }
}
