import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/10/16.
 */
public class FindModeinBinarySearchTree {
    private List<Integer> ans = new ArrayList<>();
    private int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        help(root);
        int[] ans0 = new int[ans.size()];
        for (int i = 0; i < ans0.length; i++)
            ans0[i] = ans.get(i);
        return ans0;
    }

    public void help(TreeNode node) {
        int count = 1;
        if (node.left != null) {
            count += find(node.left, node.val);
            help(node.left);
        }
        if (node.right != null) {
            count += find(node.right, node.val);
            help(node.right);
        }
        if (max < count) {
            ans = new ArrayList<>();
            ans.add(node.val);
            max = count;
        } else if (max == count)
            ans.add(node.val);
    }

    public int find(TreeNode node, int tar) {
        if (node == null)
            return 0;
        if (node.val == tar)
            return 1 + find(node.left, tar) + find(node.right, tar);
        else if (node.val < tar)
            return find(node.right, tar);
        else
            return find(node.left, tar);
    }
}
