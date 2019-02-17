package tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Delete Item ----------");
        String id = input.ask("Please, provide Item's ID: ");
        if (tracker.delete(id)) {
            System.out.println("---------- Item is deleted ----------");
        } else {
            System.out.println("----------- Item is not deleted ----------");
        }
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete Item");
    }
}