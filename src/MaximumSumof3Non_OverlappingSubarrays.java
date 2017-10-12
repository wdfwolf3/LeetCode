/**
 * Created by wdfwolf3 on 2017/10/1.
 */
public class MaximumSumof3Non_OverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length - 2 * k;
        int left = 0, first = 0, mid = 0;
        int[] ans = new int[3];
        ans[0] = 0;
        ans[1] = k;
        for (int i = 0; i < k; i++)
            left += nums[i];
        int leftMax = left;
        for (int i = k, l = 2 * k; i < l; i++)
            mid += nums[i];
        int[][] dp = new int[nums.length][2];
        for (int i = nums.length - 1, l = nums.length - k; i >= l; i--)
            dp[l][0] += nums[i];
        dp[nums.length - k][1] = nums.length - k;
        int right = dp[nums.length - k][0];
        for (int i = nums.length - k - 1, l = 2 * k; i >= l; i--) {
            right = right + nums[i] - nums[i + k];
            if (right > dp[i + 1][0]) {
                dp[i][0] = right;
                dp[i][1] = i;
            } else {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1];
            }
        }
        right = dp[2 * k][0];
        ans[2] = dp[2 * k][1];
        int sum = left + mid + right;
        for (int i = k + 1; i <= length; i++) {
            left = left - nums[i - k - 1] + nums[i - 1];
            if (left > leftMax) {
                leftMax = left;
                first = i - k;
            }
            mid = mid - nums[i - 1] + nums[i + k - 1];
            int tmp = leftMax + mid + dp[i + k][0];
            if (tmp > sum) {
                ans[0] = first;
                ans[1] = i;
                ans[2] = dp[i + k][1];
                sum = tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSumof3Non_OverlappingSubarrays m = new MaximumSumof3Non_OverlappingSubarrays();
        int[] nums = {17, 7, 19, 11, 1, 19, 17, 6, 13, 18, 2, 7, 12, 16, 16, 18, 9, 3, 19, 5};
        System.out.println(m.maxSumOfThreeSubarrays(nums, 6));
    }
}
