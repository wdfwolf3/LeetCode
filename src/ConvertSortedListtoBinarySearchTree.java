/**
 * Created by wdfwolf3 on 2017/5/23.
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return help(head, null);
    }

    public TreeNode help(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        if (head.next == tail)
            return new TreeNode(head.val);
        ListNode slow = head.next, fast = head.next.next;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = help(head, slow);
        root.right = help(slow.next, tail);
        return root;
    }
}
