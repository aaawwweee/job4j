package tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String nLine = System.lineSeparator();
    private String menu = new StringBuilder()
            .append("0. Add Item.").append(nLine)
            .append("1. Show all Items.").append(nLine)
            .append("2. Edit Item.").append(nLine)
            .append("3. Delete Item.").append(nLine)
            .append("4. Find Item by ID.").append(nLine)
            .append("5. Find Item by Name.").append(nLine)
            .append("6. Exit.")
            .toString();

    @Before
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
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu).append(nLine)
                                .append("---------- Show all Items ----------").append(nLine)
                                .append("Item's ID: " + item.getId() + nLine + "Item's Name: " + item.getName()
                                        + nLine + "Item's description: " + item.getDesc()).append(nLine)
                                .append(menu).append(nLine)
                                .append("Have a nice day. Goodbye.").append(nLine)
                                .toString()
                ));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu).append(nLine)
                                .append("---------- Find Item by Name ----------").append(nLine)
                                .append("Item's ID: " + item.getId() + nLine + "Item's Name: " + item.getName()
                                        + nLine + "Item's description: " + item.getDesc()).append(nLine)
                                .append(menu).append(nLine)
                                .append("Have a nice day. Goodbye.").append(nLine)
                                .toString()
                ));
    }
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu).append(nLine)
                                .append("---------- Find Item by ID ----------").append(nLine)
                                .append("Item's ID: " + item.getId() + nLine + "Item's Name: " + item.getName()
                                        + nLine + "Item's description: " + item.getDesc()).append(nLine)
                                .append(menu).append(nLine)
                                .append("Have a nice day. Goodbye.").append(nLine)
                                .toString()

                ));
    }
    @Test
    public void whenFindByIdThenNoElement() {
        Tracker tracker = new Tracker();
        String id = "2019";
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(id));
    }
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "replacing item", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>();
        items.add(new Item("testname", "testdesc"));
        Input input = new StubInput(new String[]{"3", items.get(0).getId(), "6"});
        new StartUI(input, tracker).init();
        items.clear();
        assertThat(items.isEmpty(), is(true));
    }
}