import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wdfwolf3 on 2017/8/20.
 */
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 1;
        queue.add(root);
        while (queue.size() != 0) {
            int s = queue.size(), tmp = 0, nul = 0;
            boolean has = false;
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nul++;
                } else {
                    if (has) {
                        tmp += (nul + 1);
                        while (nul != 0) {
                            queue.add(null);
                            queue.add(null);
                            nul--;
                        }
                    } else {
                        has = true;
                        tmp++;
                        nul = 0;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
