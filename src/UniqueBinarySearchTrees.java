/**
 * Created by wdfwolf3 on 2017/10/18.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0, l = i / 2; j < l; j++)
                dp[i] += dp[j] * dp[i - 1 - j] * 2;
            if (i % 2 == 1)
                dp[i] += dp[(i - 1) / 2] * dp[(i - 1) / 2];
        }
        return dp[n];
    }
}
