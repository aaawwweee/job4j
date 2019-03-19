package tracker;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 19.03.2019
 * @version 1
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();

}
