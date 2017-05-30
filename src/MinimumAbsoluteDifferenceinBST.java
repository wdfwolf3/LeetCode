/**
 * Created by wdfwolf3 on 2017/5/17.
 */
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        if(root == null || (root.left ==null && root.right == null))
            return Integer.MAX_VALUE;
        if(root.left == null){
            TreeNode right = root.right;
            while (right.left != null)
                right = right.left;
            return Math.min(right.val-root.val, getMinimumDifference(root.right));
        }
        if(root.right == null){
            TreeNode left = root.left;
            while (left.right != null)
                left = left.right;
            return Math.min(root.val-left.val, getMinimumDifference(root.left));
        }
        TreeNode left = root.left;
        while (left.right != null)
            left = left.right;
        TreeNode right = root.right;
        while (right.left != null)
            right = right.left;
        return Math.min(Math.min(right.val - root.val, root.val - left.val), Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
    }
}
