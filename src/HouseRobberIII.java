/**
 * Created by wdfwolf3 on 2017/6/2.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int ans = root.val;
        if (root.left != null)
            ans += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            ans += rob(root.right.left) + rob(root.right.right);
        ans = Math.max(ans, rob(root.left) + rob(root.right));
        return ans;
    }

    public int[] help(TreeNode node) {
        if (node == null)
            return new int[2];
        int[] ans = new int[2];
        ans[0] = node.val + help(node.left)[1] + help(node.right)[1];
        int[] left = help(node.left);
        int[] right = help(node.right);
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}
