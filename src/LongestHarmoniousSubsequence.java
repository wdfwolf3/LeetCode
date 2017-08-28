import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/5/22.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1))
                ans = Math.max(ans, map.get(entry.getKey() + 1) + entry.getValue());
        }
        return ans;
    }
}
