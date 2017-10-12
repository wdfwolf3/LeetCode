public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        int[] ans = {0};
        int tmp = Math.abs(help(root.left, ans) - help(root.right, ans));
        return ans[0] + tmp;
    }

    public int help(TreeNode node, int[] nums) {
        if (node == null)
            return 0;
        int l = help(node.left, nums), r = help(node.right, nums);
        nums[0] += Math.abs(l - r);
        return l + r + node.val;
    }
}
