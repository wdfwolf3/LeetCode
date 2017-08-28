public class FourKeysKeyboard {
    public int maxA(int N) {
        if (N < 7)
            return N;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= 6; i++)
            dp[i] = i;
        for (int i = 7; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++)
                max = Math.max(max, dp[j] * (i - j - 1));
            dp[i] = max;
        }
        return dp[N];
    }
}
