package tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {
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