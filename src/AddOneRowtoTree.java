import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wdfwolf3 on 2017/6/18.
 */
public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        for (int i = 1; i < d - 1; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {

                TreeNode node = list.poll();
                System.out.println(node.val);
                if (node.left != null)
                    list.offer(node.left);
                if (node.right != null)
                    list.offer(node.right);
            }
        }
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            TreeNode left = new TreeNode(v);
            left.left = node.left;
            node.left = left;
            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.right = right;
        }
        return root;
    }
}
