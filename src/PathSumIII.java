/**
 * Created by wdfwolf3 on 2017/10/16.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ans = (root.val == sum ? 1 : 0);
        ans += (pathSum(root.left, sum) + pathSum(root.right, sum));
        ans += (help(root.left, sum - root.val) + help(root.right, sum - root.val));
        return ans;
    }

    public int help(TreeNode node, int sum) {
        if (node == null)
            return 0;
        int ans = (node.val == sum ? 1 : 0);
        return ans + help(node.left, sum - node.val) + help(node.right, sum - node.val);
    }
}
