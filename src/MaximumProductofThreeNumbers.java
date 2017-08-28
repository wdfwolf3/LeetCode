import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/6/25.
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        if (nums[0] >= 0 || nums[last] <= 0)
            return nums[last] * nums[last - 1] * nums[last - 2];
        return Math.max(nums[last] * nums[last - 1] * nums[last - 2], nums[0] * nums[1] * nums[last]);
    }
}
