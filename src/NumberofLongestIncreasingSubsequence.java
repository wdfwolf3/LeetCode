/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;
        int[] dp = new int[nums.length];
        int[] ans = new int[nums.length];
        dp[0] = 1;
        ans[0] = 1;
        int max = 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        ans[i] = 1;
                    } else if (dp[j] + 1 == dp[i])
                        ans[i] += ans[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max)
                res += ans[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 7, 8};
        System.out.println(new NumberofLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
}
