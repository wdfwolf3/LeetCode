import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            height++;
        }
        int n = (int) Math.pow(2, height) - 1;
        List<List<String>> ans = new ArrayList<>();
        Queue<Integer> index = new LinkedList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        index.offer(n / 2);
        stack.offer(root);
        for (int i = 1, distance = (int) Math.pow(2, height - 2); i <= height; i++, distance /= 2) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++)
                list.add("");
            int num = index.size();
            for (int j = 0; j < num; j++) {
                TreeNode node = stack.poll();
                int in = index.poll();
                list.set(in, node.val + "");
                if (node.left != null) {
                    stack.offer(node.left);
                    index.offer(in - distance);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                    index.offer(in + distance);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Integer[] nums = {1, null, null, 2};
        System.out.println(new PrintBinaryTree().printTree(ArrayToTreeRoot.arrayToTreeRoot(nums)));
    }
}
