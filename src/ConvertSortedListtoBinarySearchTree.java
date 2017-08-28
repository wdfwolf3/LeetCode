/**
 *
 * Created by wdfwolf3 on 2017/5/23.
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        return help(head, null);
    }

    public TreeNode help(ListNode head, ListNode tail){
        if (head == tail)
            return new TreeNode(head.val);
        else if (head.next ==tail){
            TreeNode ans = new TreeNode(head.val);
            ans.right = new TreeNode(tail.val);
            return ans;
        }
        ListNode fast = head, slow = head;
        while (fast!=tail && fast.next!=tail){

        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}