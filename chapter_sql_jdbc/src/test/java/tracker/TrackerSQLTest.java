package tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;


public class TrackerSQLTest {
    @Test
    public void whenCreateTable() {
        try {
            TrackerSQL sql = new TrackerSQL();
            assertThat(sql.init(), is(true));
            assertThat(sql.createBase(), is(true));
            assertThat(sql.dropTheTable(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void whenAddingNewItemInTheTable() {
        try {
            TrackerSQL sql = new TrackerSQL();
            sql.init();
            sql.createBase();
            Item item = new Item("Alexander", "lalala");
            assertThat(sql.add(item), is(item));
            assertThat(sql.dropTheTable(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void whenReplaceItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.createBase();
        Item item = new Item("Alexander", "lalala");
        Item item2 = new Item("Pops", "ololo");
        sql.add(item);
        sql.add(item2);
        assertThat(sql.replace("1", item2), is(true));
        assertThat(sql.dropTheTable(), is(true));
    }
    @Test
    public void whenDeleteItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.createBase();
        Item item = new Item("Alexander", "lalala");
        Item item2 = new Item("Pops", "ololo");
        sql.add(item);
        sql.add(item2);
        assertThat(sql.delete("1"), is(true));
        assertThat(sql.dropTheTable(), is(true));
    }
    @Test
    public void whenFindAllItems() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.createBase();
        Item item = new Item("Alexander", "lalala");
        Item item2 = new Item("Pops", "ololo");
        sql.add(item);
        sql.add(item2);
        List<Item> result = sql.findAll();
        assertThat(result.get(1).getName(), is(item2.getName()));
        assertThat(sql.dropTheTable(), is(true));
    }
    @Test
    public void whenFindItemByName() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.createBase();
        Item item = new Item("Alexander", "lalala");
        Item item2 = new Item("Pops", "ololo");
        sql.add(item);
        sql.add(item2);
        assertThat(sql.findByName("Pops").get(0).getName(), is(item2.getName()));
        assertThat(sql.dropTheTable(), is(true));
    }
    @Test
    public void whenFindItemById() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        sql.createBase();
        Item item = new Item("Alexander", "lalala");
        Item item2 = new Item("Pops", "ololo");
        sql.add(item);
        sql.add(item2);
        assertThat(sql.findById("1"), is(item));
        assertThat(sql.dropTheTable(), is(true));
    }
}
