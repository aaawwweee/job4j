package tracker;

import java.util.List;

/**
 * @author Alexander Kashkin
 * @version 1
 * @since 17.03.2019
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}