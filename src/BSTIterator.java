import java.util.Stack;
import TreeNode.TreeNode;

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<>();
	TreeNode current;
	
	public BSTIterator(TreeNode root) {
		if(root != null)
			pushLeftTreeNode(root);	
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(stack.isEmpty())
			return false;
		current = stack.pop();		
		if(current.right != null){
			pushLeftTreeNode(current.right);	
		}
		return true;
	}

	/** @return the next smallest number */
	public int next() {
		return current.val;
	}
	
	private void pushLeftTreeNode(TreeNode treeNode){
		stack.push(treeNode);
		while (treeNode.left!=null){
			treeNode = treeNode.left;
			stack.push(treeNode);
		}	
	}
}


