import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/10/19.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            cur += root.val;
            list.add(root.val);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.right == null) {
                if (root.left == null && cur == sum)
                    lists.add(new ArrayList<>(list));
                stack.pop();
                cur -= root.val;
                list.remove(list.size() - 1);
                while (!stack.isEmpty() && stack.peek().right == root) {
                    root = stack.pop();
                    cur -= root.val;
                    list.remove(list.size() - 1);
                }
            } else {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    cur += root.val;
                    list.add(root.val);
                    root = root.left;
                }
            }
        }
        return lists;
    }
}
