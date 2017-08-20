/**
 * Created by wdfwolf3 on 2017/8/20.
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        for (int i = 1; i < s.length(); i++)
            for (int j = 0; j < s.length() - i; j++) {
                dp[j][j + i] = i + 1;
                for (int k = 0; k < i; k++) {
                    int tmp = dp[j][j + k] + dp[j + k + 1][j + i];
                    if (s.charAt(j + k) == s.charAt(j + i))
                        tmp--;
                    dp[j][j + i] = Math.min(dp[j][j + i], tmp);
                }
            }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new StrangePrinter().strangePrinter(s));
    }
}
