public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[] dp = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            dp[i] = (A[0] == B[i]) ? 1 : 0;
            ans = Math.max(ans, dp[i]);
        }
        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[B.length];
            cur[0] = (A[i] == B[0]) ? 1 : 0;
            ans = Math.max(ans, cur[0]);
            for (int j = 1; j < B.length; j++) {
                cur[j] = (A[i] == B[j]) ? (dp[j - 1] + 1) : 0;
                ans = Math.max(cur[j], ans);
            }
            dp = cur;
        }
        return ans;
    }
}
