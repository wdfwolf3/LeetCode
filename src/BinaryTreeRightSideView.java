import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/10/17.
 */
public class BinaryTreeRightSideView {
    private List<Integer> ans = new ArrayList<>();
    ;

    public List<Integer> rightSideView(TreeNode root) {
        if (root != null)
            rightSideView(root, 1);
        return ans;
    }

    public void rightSideView(TreeNode root, int height) {
        if (height > ans.size())
            ans.add(root.val);
        if (root.right != null)
            rightSideView(root.right, height + 1);
        if (root.left != null)
            rightSideView(root.left, height + 1);
    }
}
