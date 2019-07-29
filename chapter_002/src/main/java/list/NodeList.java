package list;

/**
 * Check if Nodes have loop
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 02.06.2019
 * @version 1
 */
public class NodeList {
    public boolean hasCycle(Node first) {
        Node tortoise = first;
        Node hare = first;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }
}
