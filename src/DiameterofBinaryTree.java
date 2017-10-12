public class DiameterofBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int l = help(root.left), r = help(root.right);
        ans = Math.max(ans, l + r + 2);
        return ans;
    }

    public int help(TreeNode node) {
        if (node == null)
            return -1;
        int l = help(node.left), r = help(node.right);
        ans = Math.max(Math.max(ans, l + r + 2), Math.max(l, r));
        return Math.max(l, r) + 1;
    }
}
