package list;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeListTest {
    private NodeList nodeList;
    private Node<Integer> first, second, third, fourth;

    @Before
    public void createCycle() {
        nodeList = new NodeList();
        first = new Node<>(1);
        second = new Node<>(2);
        third = new Node<>(3);
        fourth = new Node<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
    }

    @Test
    public void noLoopReturnFalse() {
        assertFalse(nodeList.hasCycle(first));
    }
    @Test
    public void hasLoopReturnTrue() {
        second.next = first;
        assertTrue(nodeList.hasCycle(first));
    }
}
