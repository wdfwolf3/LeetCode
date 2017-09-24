/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;
        int ans = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                count++;
            else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return Math.max(ans, count);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 9, 11, 4, 13};
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
    }
}
