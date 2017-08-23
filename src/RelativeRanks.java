import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        Arrays.sort(nums);
        String[] ans = new String[nums.length];
        int i, j = nums.length - 1;
        for (i = 0; i < nums.length - 3; i++) {
            ans[map.get(nums[i])] = nums.length - i + "";
        }
        if (j >= i)
            ans[map.get(nums[j--])] = "Gold Medal";
        if (j >= i)
            ans[map.get(nums[j--])] = "Silver Medal";
        if (j >= i)
            ans[map.get(nums[j])] = "Bronze Medal";
        return ans;
    }
}
