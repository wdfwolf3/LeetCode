/**
 * Created by wdfwolf3 on 2017/8/23.
 */
public class OutofBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0)
            return 0;
        int[][][] dp = new int[N + 1][m][n];
        int mod = 1000000007;
        for (int k = 1; k <= N; k++)
            for (int l = 0; l < m; l++)
                for (int o = 0; o < n; o++) {
                    dp[k][l][o] = (dp[k][l][o] + (l == 0 ? 1 : dp[k - 1][l - 1][o])) % mod;
                    dp[k][l][o] = (dp[k][l][o] + (o == 0 ? 1 : dp[k - 1][l][o - 1])) % mod;
                    dp[k][l][o] = (dp[k][l][o] + (l == (m - 1) ? 1 : dp[k - 1][l + 1][o])) % mod;
                    dp[k][l][o] = (dp[k][l][o] + (o == (n - 1) ? 1 : dp[k - 1][l][o + 1])) % mod;
                }
        return dp[N][i][j];
    }
}
