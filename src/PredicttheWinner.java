/**
 * Created by wdfwolf3 on 2017/7/11.
 */
public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        if (length < 3)
            return true;
        int[][] sums = new int[length][length];
        int[][] dp = new int[length][length];
        for (int i = 0, j = 0; i < length; i++) {
            for (j = 0; j < i; j++)
                sums[j][i] = sums[j][i - 1] + nums[i];
            sums[j][i] = nums[i];
            dp[j][i] = nums[i];
        }
        for (int i = 1; i < length; i++)
            for (int j = 0, k = i; k < length; j++, k++)
                dp[j][k] = Math.max(nums[j] + sums[j + 1][k] - dp[j + 1][k], nums[k] + sums[j][k - 1] - dp[j][k - 1]);
        return dp[0][length - 1] >= (sums[0][length - 1] - dp[0][length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println(new PredicttheWinner().PredictTheWinner(nums));
    }
}
