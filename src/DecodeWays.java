/**
 * Created by wdfwolf3 on 2017/6/7.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.equals("") || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        int pre = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (pre == 1 || (pre == 2 && n < 7))
                dp[i + 1] = dp[i - 1];
            if (n != 0)
                dp[i + 1] += dp[i];
            pre = n;
        }
        return dp[s.length()];
    }
}
