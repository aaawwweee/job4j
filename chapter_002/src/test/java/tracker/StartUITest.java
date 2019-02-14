package tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String newLine = System.getProperty("line.separator");
    private final String menus = new StringBuilder()
            .append("0. Add new Item").append(newLine)
            .append("1. Show all items").append(newLine)
            .append("2. Edit item").append(newLine)
            .append("3. Delete item").append(newLine)
            .append("4. Find item by Id").append(newLine)
            .append("5. Find item by Name").append(newLine)
            .append("6. Exit Program").append(newLine)
            .toString();

    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void showAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc", 2018L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menus)
                                .append("ID заявки: " + item.getId() + " " + "Имя заявки: " + item.getName() + " Описание заявки: " + item.getDesc()).append(newLine)
                                .append(menus)
                                .toString()
                ));
    }
    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc", 2018L));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void addNewItemInTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "USA", "love", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("USA"));
    }

    @Test
    public void updateItemInTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc", 2018L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void deleteItemInTracker() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "desc", 2018L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void findItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test", "USA", 2018L));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getDesc(), is("USA"));
    }
}