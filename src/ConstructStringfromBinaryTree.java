/**
 * Created by wdfwolf3 on 2017/6/4.
 */
public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        else if(t.right == null && t.left == null)
            return String.valueOf(t.val);
        else if(t.right == null)
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")";
        else if(t.left == null)
            return String.valueOf(t.val) + "()(" + tree2str(t.right) + ")";
        else
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
