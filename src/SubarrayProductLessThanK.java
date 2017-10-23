/**
 * Created by wdfwolf3 on 2017/10/23.
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, product = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (j = Math.max(i, j); j < nums.length; j++) {
                product *= nums[j];
                if (product >= k) {
                    product /= nums[j];
                    break;
                }
            }
            if (j > i) {
                product /= nums[i];
                ans += j - i;
            }
        }
        return ans;
    }
}
