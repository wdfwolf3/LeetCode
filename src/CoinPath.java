import java.util.*;

public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[A.length];
        int[] index = new int[A.length];
        for (int i = 0,len = Math.min(B,A.length); i < len; i++) {
            dp[i] = A[i];
            index[i] = -1;
        }
        for (int i = B; i < A.length; i++) {
            if (A[i] == -1)
                dp[i] = -1;
            else {
                int min = Integer.MAX_VALUE, n = -1;
                for (int j = i-B; j < i; j++)
                    if (dp[j] >= 0 && dp[j] < min){
                        min = dp[j];
                        n = j;
                    }
                if (min == Integer.MAX_VALUE)
                    return ans;
                dp[i] = A[i] + min;
                index[i] = n;
            }
        }
        ans.add(A.length);
        int cur = index[A.length-1];
        while (cur!=-1){
            ans.add(cur+1);
            cur = index[cur];
        }
        Collections.reverse(ans);
        return ans;
    }
}
