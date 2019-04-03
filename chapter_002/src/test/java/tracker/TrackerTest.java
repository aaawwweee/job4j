package tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItem() {
        List<Item> items = new ArrayList<>();
        Item item = new Item("name1", "desc1");
        items.add(item);
        assertThat(items.get(0), is(item));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testname", "testdesc", 123L);
        tracker.add(previous);
        Item next = new Item("testname2", "testdesc2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("testname2"));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testname1", "testdesc1", 1L);
        Item item2 = new Item("testname1", "testdesc2", 2L);
        Item item3 = new Item("testname3", "testdesc3", 3L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = {item1, item2};
        assertThat(tracker.findByName("testname1"), is(expected));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testname1", "testdesc1", 1L);
        Item item2 = new Item("testname1", "testdesc2", 2L);
        Item item3 = new Item("testname3", "testdesc3", 3L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        boolean rst = tracker.delete(item1.getId());
        assertThat(rst, is(true));
    }
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testname1", "testdesc1", 123L);
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result, is(item1));
    }
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testname1", "testdesc1", 1L);
        Item item2 = new Item("testname2", "testdesc2", 2L);
        Item item3 = new Item("testname3", "testdesc3", 3L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findAll();
        Item[] exp = {item1, item2, item3};
        assertThat(result, is(exp));
    }
}