/**
 * Created by wdfwolf3 on 2017/6/7.
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return String.valueOf(nums[0]);
        if (nums.length == 2)
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        String ans = String.valueOf(nums[0]) + "/(";
        for (int i = 1; i < nums.length - 1; i++)
            ans += (String.valueOf(nums[i]) + "/");
        return ans + String.valueOf(nums[nums.length - 1]) + ")";
    }
}
