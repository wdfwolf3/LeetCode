/**
 * Created by wdfwolf3 on 2017/10/20.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || preorder.length != inorder.length)
            return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (il < ir)
            return null;
        else if (il == ir)
            return new TreeNode(inorder[il]);
        int rVal = preorder[pl], i;
        for (i = il; i <= ir; i++)
            if (inorder[i] == rVal)
                break;
        TreeNode root = new TreeNode(rVal);
        root.left = buildTree(preorder, pl + 1, pl + i - il, inorder, il, i - 1);
        root.right = buildTree(preorder, pl + 1 + i - il, pr, inorder, i + 1, ir);
        return root;
    }
}
