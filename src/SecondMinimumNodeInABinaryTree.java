public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;
        int l, r;
        if (root.val != root.left.val)
            l = root.left.val;
        else
            l = findSecondMinimumValue(root.left);
        if (root.val != root.right.val)
            r = root.right.val;
        else
            r = findSecondMinimumValue(root.right);
        if (r == -1 && l == -1)
            return -1;
        else if (l == -1)
            return r;
        else if (r == -1)
            return l;
        else
            return Math.min(l, r);
    }
}
