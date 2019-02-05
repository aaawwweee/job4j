package tracker;

public class StartUI {
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private void showMenu() {
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit Item\n"
                + "3. Delete item\n"
                + "4. Find items by Id\n"
                + "5. Find item by names\n"
                + "6. Exit Program\n");
    }

    private void createItem() {
        System.out.println("----------- Добавление новой заявки ----------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc, 123123L);
        this.tracker.add(item);
        System.out.println("---------- Новая заявка с getId: " + item.getId() + "----------");
    }

    private void showItems() {
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("ID заявки:" + item.getId() + " " + "Имя заявки:" + item.getName() + " Описание заявки: ");
        }
    }

    private void editItems() {
        System.out.println("----------- Редактирование заявки ----------");
        String id = this.input.ask("Введите ID заявки для редактирования: ");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc, 123123L);
        boolean a = tracker.replace(id, item);
        if (a) {
            System.out.println("---------- Заявка отредактирована ----------");
        } else {
            System.out.println("---------- Заявка не отредактирована ----------");
        }
    }

    private void findItemById() {
        System.out.println("---------- Поиск заявки по ID ----------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        System.out.println("ID заявки: " + item.getId() + " Имя заявки: " + item.getName() + " Описание заявки: " + item.getDesc());
    }

    private void findItemsByName() {
        System.out.println("---------- Поиск заявки по имени ----------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println("ID заявки: " + item.getId() + " Имя заявки: " + item.getName() + " Описание заявки: " + item.getDesc());
        }
    }

    private void deleteItems() {
        System.out.println("---------- Удаление заявки ----------");
        String id = this.input.ask("Введите ID заявки: ");
        boolean a = this.tracker.delete(id);
        if (a) {
            System.out.println("---------- Заявка удалена ----------");
        } else {
            System.out.println("---------- Заявка не удалена ----------");
        }
    }
        public void init() {
            boolean exit = false;
            while (!exit) {
                this.showMenu();
                String answer = this.input.ask("Select:");
                if (ADD.equals(answer)) {
                    this.createItem();
                } else if (SHOWALL.equals(answer)) {
                    this.showItems();
                } else if (EDIT.equals(answer)) {
                    this.editItems();
                } else if (FINDBYID.equals(answer)) {
                    this.findItemById();
                } else if (DELETE.equals(answer)) {
                    this.deleteItems();
                } else if (FINDBYNAME.equals(answer)) {
                    this.findItemsByName();
                } else if (EXIT.equals(answer)) {
                    exit = true;
                }
            }
        }
    }