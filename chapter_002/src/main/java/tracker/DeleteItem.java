package tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
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
}