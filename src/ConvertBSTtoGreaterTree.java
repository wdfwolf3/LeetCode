import java.util.Stack;

public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = root;
        stack.push(root);
        while (root.right != null) {
            root = root.right;
            stack.push(root);
        }
        int sum = 0;
        while (root != null) {
            root.val += sum;
            sum = root.val;
            root = help(root, stack);
        }
        return ans;
    }

    public TreeNode help(TreeNode node, Stack<TreeNode> stack) {
        if (node.left != null) {
            stack.push(node.left);
            node = node.left;
            while (node.right != null) {
                node = node.right;
                stack.push(node);
            }
            return node;
        }
        stack.pop();
        while (!stack.isEmpty() && stack.peek().left == node)
            node = stack.pop();
        return stack.size() == 0 ? null : stack.peek();
    }
}
