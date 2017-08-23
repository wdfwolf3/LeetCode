package TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/13.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        assist(root, ans);
        return ans;
    }

    private void assist(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        assist(root.left, list);
        assist(root.right, list);
    }
}
