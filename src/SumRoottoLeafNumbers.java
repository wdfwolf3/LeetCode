/**
 * Created by wdfwolf3 on 2017/10/19.
 */
public class SumRoottoLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    public void sumNumbers(TreeNode node, int val) {
        if (node == null)
            return;
        val = val * 10 + node.val;
        if (node.left == null && node.right == null)
            sum += val;
        else {
            sumNumbers(node.left, val);
            sumNumbers(node.right, val);
        }
    }
}
