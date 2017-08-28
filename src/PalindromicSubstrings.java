/**
 * Created by wdfwolf3 on 2017/7/23.
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 3}, {1, 5}, {1, 3}, {3, 4}};
        String string = "";
        System.out.println(new PalindromicSubstrings().countSubstrings(string));
    }

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                dp[j][j + i] = (dp[j + 1][j + i - 1]) && (s.charAt(j) == s.charAt(j + i));
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j])
                    ans++;
            }
        }
        return ans;
    }
}
