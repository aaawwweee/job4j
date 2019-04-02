package search;
import java.util.LinkedList;

/**
 * @author Alexander Kashkin
 * @since 01.04.2019
 * @version 1
 */
public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int x = tasks.size();
        for (int i = 0; i < x; i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                x = i;
                break;
            }
        }
        this.tasks.add(x, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}