/**
 * Created by wdfwolf3 on 2017/8/23.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root != null) {
            TreeLinkNode node = new TreeLinkNode(0), parent = root;
            root = null;
            while (parent != null) {
                if (parent.left != null) {
                    node.next = parent.left;
                    node = node.next;
                    if (root == null)
                        root = node;
                }
                if (parent.right != null) {
                    node.next = parent.right;
                    node = node.next;
                    if (root == null)
                        root = node;
                }
                parent = parent.next;
            }
        }
    }
}
