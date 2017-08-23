/**
 * Created by wdfwolf3 on 2017/7/16.
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        for (int i = 0; i < k; i++)
            ans += nums[i];
        double sum = ans;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            ans = Math.max(ans, sum);
        }
        return ans / k;
    }
}
