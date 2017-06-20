import java.util.Random;

/**
 * Created by wdfwolf3 on 2017/6/20.
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode node = head;
        int count = 0, value = 0;
        while (node != null) {
            if (random.nextInt(++count) == 0) value = node.val;
            node = node.next;
        }
        return value;
    }
}
