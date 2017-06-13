/**
 * Created by wdfwolf3 on 2017/6/13.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        for (int i = nums.length - 2, p = 1; i >= 0; i--) {
            p *= nums[i + 1];
            ans[i] *= p;
        }
        return ans;
    }
}
