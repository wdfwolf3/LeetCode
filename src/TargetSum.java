/**
 * Created by wdfwolf3 on 2017/7/11.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        return help(nums, nums.length - 1, S);
    }

    public int help(int[] nums, int end, int s) {
        if (nums.length == 1)
            if (nums[0] == s || nums[0] + s == 0)
                return 1;
            else
                return 0;
        return help(nums, end - 1, s - nums[end]) + help(nums, end - 1, s + nums[end]);
    }
}
