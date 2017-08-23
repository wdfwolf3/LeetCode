import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2)
            ans += nums[i];
        return ans;
    }
}
