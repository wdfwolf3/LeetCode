/**
 * Created by wdfwolf3 on 2017/6/2.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int ans = 1, last = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = ans;
            ans += last;
            last = tmp;
        }
        return ans;
    }
}
