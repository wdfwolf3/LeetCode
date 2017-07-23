/**
 * Created by wdfwolf3 on 2017/7/11.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][i] = nums[i - 1];
//            dp[i][i-1] = 1;
        }
        dp[0][0] = dp[nums.length + 1][nums.length + 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1, k = i + 1; k <= nums.length; j++, k++) {
                int max = Integer.MIN_VALUE;
                for (int l = j+1; l < k; l++) {
                    int tmp = dp[j][l - 1] + dp[l + 1][k] + dp[l - 1][l - 1] * dp[l][l] * dp[l + 1][l + 1];
                    max = Math.max(max, tmp);
                }
                max = Math.max(max, dp[j + 1][k] + dp[j][j] * dp[j + 1][j + 1]);
                max = Math.max(max, dp[j][k - 1] + dp[j][j] * dp[j - 1][j - 1]);
                dp[j][k] = max;
            }
        }
        return dp[1][nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(new BurstBalloons().maxCoins(nums));
    }
}
