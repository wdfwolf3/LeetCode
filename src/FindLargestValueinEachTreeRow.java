import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/10/17.
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        largestValues(root, 1, ans);
        return ans;
    }

    public void largestValues(TreeNode node, int height, List<Integer> list) {
        if (height > list.size())
            list.add(node.val);
        else
            list.set(height - 1, Math.max(list.get(height - 1), node.val));
        if (node.left != null)
            largestValues(node.left, height + 1, list);
        if (node.right != null)
            largestValues(node.right, height + 1, list);
    }
}
