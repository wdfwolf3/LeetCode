/**
 * Created by wdfwolf3 on 2017/10/1.
 */
public class LongestUnivaluePath {
    public int max = 1;

    public int longestUnivaluePath(TreeNode root) {
        help(root);
        return max - 1;
    }

    public int help(TreeNode node) {
        if (node == null)
            return 0;
        int ans = 1, l = 0, r = 0, tmp = 0;
        if (node.left != null) {
            l = help(node.left);
            if (node.left.val == node.val) {
                ans += l;
                tmp = l;
            }
        }
        if (node.right != null) {
            r = help(node.right);
            if (node.right.val == node.val) {
                ans += r;
                tmp = Math.max(tmp, r);
            }
        }
        max = Math.max(max, ans);
        return tmp + 1;
    }
}
