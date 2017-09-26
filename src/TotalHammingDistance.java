public class TotalHammingDistance {
    public static void main(String args[]) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

    public static int totalHammingDistance(int[] nums) {
        int len = nums.length, ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum0 = 0;
            for (int j = 0; j < len; j++) {
                if (((nums[j] >>> i) & 1) == 0)
                    sum0++;
            }
            ans += sum0 * (len - sum0);
        }
        return ans;
    }
}
