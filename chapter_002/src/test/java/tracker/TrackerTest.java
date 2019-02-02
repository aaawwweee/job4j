package tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
        @Test
        public void whenDelete() {
            Tracker tracker = new Tracker();
            Item item = new Item("one", "hihi", 10);
            tracker.add(item);
            boolean res = tracker.delete(item.getId());
            assertThat(res, is(true));
        }
        @Test
        public void whenFindAll() {
            Tracker tracker = new Tracker();
            Item item1 = new Item("testA", "hihihi", 1);
            Item item2 = new Item("testB", "hihihi", 2);
            Item item3 = new Item("testC", "hihihi", 3);
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            Item[] expected = {item1, item2, item3};
            assertThat(tracker.findAll(), is(expected));
        }
        @Test
        public void whenFindById() {
            Tracker tracker = new Tracker();
            Item item1 = new Item("testA", "hihi", 1);
            Item item2 = new Item("testB", "hihi", 2);
            Item item3 = new Item("testC", "hihi", 3);
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findById(item3.getId()), is(item3));
        }
        @Test
        public void whenFindByName() {
            Tracker tracker = new Tracker();
            Item item1 = new Item("testA", "hihi", 1);
            Item item2 = new Item("testB", "hihi", 2);
            Item item3 = new Item("testC", "hihi", 3);
            Item item4 = new Item("testC", "bye bye", 10);
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            tracker.add(item4);
            Item[] expected = {item3, item4};
            assertThat(tracker.findByName("testC"), is(expected));
        }
    }