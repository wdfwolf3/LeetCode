/**
 * Created by wdfwolf3 on 2017/7/23.
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        String string = "";
        System.out.println(new SetMismatch().findErrorNums(nums));
    }

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        boolean[] sign = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (sign[nums[i]] == true)
                ans[0] = nums[i];
            else
                sign[nums[i]] = true;
        }
        for (int i = 1; i < sign.length; i++) {
            if (!sign[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
