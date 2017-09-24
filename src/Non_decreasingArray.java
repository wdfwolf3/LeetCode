/**
 * Created by wdfwolf3 on 2017/8/28.
 */
public class Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean ans = false;
        int i = 1;
        if (nums[1] < nums[0]) {
            ans = true;
            i++;
        }
        for (; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1])
                continue;
            else if (ans)
                return false;
            else if (nums[i] < nums[i - 2]) {
                ans = true;
                nums[i] = nums[i - 1];
            } else
                ans = true;
        }
        return true;
    }
}
