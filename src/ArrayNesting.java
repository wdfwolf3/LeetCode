/**
 * Created by wdfwolf3 on 2017/6/8.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && nums[i] != i) {
                int f = nums[i];
                int count = 1;
                while (nums[f] != i) {
                    int tmp = nums[f];
                    nums[f] = -1;
                    f = tmp;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans == 0 ? 1 : ans;
    }
}
