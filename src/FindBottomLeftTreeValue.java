import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wdfwolf3 on 2017/10/17.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = root.val;
        while (!queue.isEmpty()) {
            ans = queue.peek().val;
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return ans;
    }
}
