package TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/12.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        assist(root, ans);
        return ans;
    }

    private void assist(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            assist(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            assist(root.right, list);
        }
    }
}
