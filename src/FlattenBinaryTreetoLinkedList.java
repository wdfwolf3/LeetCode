/**
 * Created by wdfwolf3 on 2017/10/19.
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        help(root);
    }

    public TreeNode help(TreeNode node) {
        if (node == null)
            return node;
        TreeNode right = help(node.right);
        node.right = help(node.left);
        node.left = null;
        TreeNode root = node;
        while (node.right != null)
            node = node.right;
        node.right = right;
        return root;
    }
}
