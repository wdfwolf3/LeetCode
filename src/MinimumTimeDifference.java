import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/7.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> nums = new ArrayList<>();
        for (String time : timePoints) {
            String[] hAndM = time.split(":");
            nums.add(Integer.parseInt(hAndM[0]) * 60 + Integer.parseInt(hAndM[1]));
        }
        Collections.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            ans = Math.min(ans, nums.get(i) - nums.get(i - 1));
        }
        ans = Math.min(ans, nums.get(0) + 1440 - nums.get(nums.size() - 1));
        return ans;
    }
}
