/**
 * @author wendefeng
 * @Description:
 * @date 2017-6-1 ����1:31:28
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int rob = 0, nrob = 0, ans;
        for (int i = 1; i < nums.length; i++) {
            int tmp = rob;
            rob = nrob + nums[i];
            nrob = Math.max(tmp, nrob);
        }
        ans = Math.max(rob, nrob);
        rob = 0;
        nrob = 0;
        for (int n : nums) {
            int tmp = rob;
            rob = nrob + n;
            nrob = Math.max(tmp, nrob);
        }
        return Math.max(ans, nrob);
    }
}
