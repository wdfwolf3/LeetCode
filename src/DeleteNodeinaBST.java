/**
 * Created by wdfwolf3 on 2017/10/18.
 */
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode parent = null;
        parent.left = node;
        boolean flag = false;
        while (node.val != key) {
            parent = node;
            if (node.val > key) {
                node = node.left;
                flag = true;
            } else {
                node = node.right;
                flag = false;
            }
        }
        TreeNode node0 = node;
        if (node.left == null && node.right == null)
            node = null;
        else if (node.left == null)
            node = node.right;
        else if (node.right == null)
            node = node.left;
        else {
            TreeNode tmp = node;
            node = node.right;
            if (node.left == null)
                tmp.right = node.right;
            else {
                while (node.left != null) {
                    tmp = node;
                    node = node.left;
                }
                tmp.left = node.right;
            }
            node0.val = node.val;
            node = node0;
        }
        if (parent == null)
            return node;
        if (flag)
            parent.left = node;
        else
            parent.right = node;
        return root;
    }
}
