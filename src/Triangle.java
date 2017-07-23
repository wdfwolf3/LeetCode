import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/19.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[] dp = triangle.get(triangle.size() - 1).toArray(new Integer[triangle.size()]);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
