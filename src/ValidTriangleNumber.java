import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/6/11.
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0)
                break;
        }
        int ans = 0;
        for (; i < nums.length - 2; i++) {
            for (int j = i + 1, k = j + 1; j < nums.length - 1; j++) {
                for (; k < nums.length; k++) {
                    if (nums[i] + nums[j] <= nums[k])
                        break;
                }
                ans += (k - 1 - j);
            }
        }
        return ans;
    }
}
