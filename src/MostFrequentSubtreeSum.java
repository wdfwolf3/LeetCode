import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/10/18.
 */
public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        help(root);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                list = new ArrayList<>();
                list.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max)
                list.add(entry.getKey());
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = list.get(i);
        return ans;
    }

    public int help(TreeNode node) {
        if (node == null)
            return 0;
        int tmp = node.val + help(node.left) + help(node.right);
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        return tmp;
    }
}
