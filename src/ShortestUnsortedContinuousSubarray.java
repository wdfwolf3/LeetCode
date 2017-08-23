import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/5/14.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 4};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (; start < nums.length - 1; start++) {
            if (nums[start] > nums[start + 1])
                break;
        }
        if (start == nums.length - 1)
            return 0;
        for (; end > start; end--) {
            if (nums[end] < nums[end - 1]) {
                break;
            }
        }
        int min = nums[start], max = nums[start];
        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > end; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i)))
                map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(kill);
        for (int i = 0; i < ans.size(); i++) {
            if (map.containsKey(ans.get(i)))
                ans.addAll(map.get(ans.get(i)));
        }
        return ans;
    }
}
