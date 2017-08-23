/**
 * Created by wdfwolf3 on 2017/8/23.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root.left != null) {
            TreeLinkNode node = root.left, parent = root;
            root = root.left;
            do {
                node.next = parent.right;
                node = node.next;
                parent = parent.next;
                if (parent == null)
                    break;
                else {
                    node.next = parent.left;
                    node = node.next;
                }
            } while (true);
        }
    }
}
