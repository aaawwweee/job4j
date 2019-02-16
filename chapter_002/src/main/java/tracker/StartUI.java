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
    private final String newLine = System.getProperty("line.separator");

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private void showMenu() {
        System.out.println("0. Add new Item" + newLine
                + "1. Show all Items" + newLine
                + "2. Edit Item" + newLine
                + "3. Delete Item" + newLine
                + "4. Find Item by Id" + newLine
                + "5. Find Item by Name" + newLine
                + "6. Exit Program" + newLine);
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
            System.out.println("ID заявки: " + item.getId() + " " + "Имя заявки: " + item.getName() + " Описание заявки: " + item.getDesc());
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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select:")));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
        }
    }