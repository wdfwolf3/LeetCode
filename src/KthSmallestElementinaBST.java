import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/10/18.
 */
public class KthSmallestElementinaBST {
    private Map<TreeNode, int[]> map = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        help(root);
        int[] nums = map.get(root);
        while (nums[0] + 1 != k) {
            if (nums[0] + 1 < k) {
                root = root.right;
                k -= nums[0] + 1;
            } else {
                root = root.left;
            }
            nums = map.get(root);
        }
        return root.val;
    }

    public int help(TreeNode node) {
        if (node == null)
            return 0;
        int[] nums = new int[0];
        nums[0] = help(node.left);
        nums[1] = help(node.right);
        map.put(node, nums);
        return nums[0] + nums[1] + 1;
    }
}
