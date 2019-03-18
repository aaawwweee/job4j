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
    private String nextline = System.lineSeparator();

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    private final static String ADD = "0";
    private final static String SHOWALL = "1";
    private final static String EDIT = "2";
    private final static String DELETE = "3";
    private final static String FINDBYID = "4";
    private final static String FINDBYNAME = "5";
    private final static String EXIT = "6";

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Please, enter menu item: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu. " + nextline + "0. Add new Item" + nextline
                + "1. Show all Items" + nextline + "2. Edit Item" + nextline
                + "3. Delete Item" + nextline
                + "4. Find Item by ID" + nextline + "5. Find Item by Name" + nextline
                + "6. Exit program" + nextline);
    }
    private void createItem() {
        System.out.println("---------- Adding a new Item ----------");
        String name = this.input.ask("Please, think up with the name of the Item: ");
        String desc = this.input.ask("Add description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------- New Item's ID: " + item.getId() + " ----------");
    }
    private void showAllItems() {
        System.out.println("---------- Show all Items ----------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + nextline + "Item's Name: " + item.getName()
            + nextline + "Item's description: " + item.getDesc());
        }
    }
    private void editItem() {
        System.out.println("---------- Edit the Item ----------");
        String id = this.input.ask("Please, enter the Item's ID: ");
        String name = this.input.ask("Enter the Item's Name: ");
        String desc = this.input.ask("Enter the Item's description: ");
        Item item = new Item(name, desc);
        boolean x = tracker.replace(id, item);
        if (x) {
            System.out.println("The Item has been edited");
        } else {
            System.out.println("The Item hasn't been edited");
        }
    }
    private void deleteItem() {
        System.out.println("---------- Delete the Item ----------");
        String id = this.input.ask("Please, enter the Item's ID: ");
        boolean x = this.tracker.delete(id);
        if (x) {
            System.out.println("The Item has been deleted");
        } else {
            System.out.println("The Item hasn't been deleted");
        }
    }
    private void findById() {
        System.out.println("---------- Find Item by ID ----------");
        String id = this.input.ask("Please, enter the Item's ID: ");
        Item item = tracker.findById(id);
        System.out.println("Item's ID: " + item.getId() + nextline + "Item's Name: " + item.getName()
                + nextline + "Item's description: " + item.getDesc());
    }
    private void findByName() {
        System.out.println("---------- Find Item by Name ----------");
        String name = this.input.ask("Please, enter the Item's Name: ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + nextline + "Item's Name: " + item.getName()
                    + nextline + "Item's description: " + item.getDesc());
        }
    }
}