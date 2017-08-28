/**
 * @author wendefeng
 * @Description:
 * @date 2017-6-2 ����4:24:01
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums1) {
        // if(nums == null || nums.length == 0)
        // return 0;
        int[] nums = {8, -19, 5, -4, 20};
        int ans = Integer.MIN_VALUE, current = Integer.MIN_VALUE;
        for (int i : nums) {
            if (current < 0)
                current = i;
            else
                current += i;
            ans = Math.max(ans, current);
        }
        return ans;
    }
}
