package tracker;
import java.util.List;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 18.03.2019
 */
public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }
    public String ask(String question) {
        return this.value[this.position++];
    }
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}