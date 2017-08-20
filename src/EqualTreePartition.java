import java.util.HashSet;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/8/20.
 */
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return false;
        Set<Integer> set = new HashSet<>();
        int sum = help(set, root);
        return sum % 2 == 0 && set.contains(sum / 2);
    }

    public int help(Set<Integer> set, TreeNode node) {
        int ans = 0;
        if (node == null)
            ans = 0;
        else if (node.left == null && node.right == null)
            ans = node.val;
        else if (node.left == null)
            ans = node.val + help(set, node.right);
        else if (node.right == null)
            ans = node.val + help(set, node.left);
        else
            ans = node.val + help(set, node.left) + help(set, node.right);
        set.add(ans);
        return ans;
    }
}
