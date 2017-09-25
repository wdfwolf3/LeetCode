import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 16, 32, 64};
        System.out.println(threeSumClosest1(nums, 82));
    }

    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        if (n <= 3) {
            for (int num : nums)
                res += num;
            return res;
        }

        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - res) >= Math.abs(target - sum)) {
                    res = sum;
                    if (res == target) return res;
                }
                if (sum > target) k--;
                else if (sum < target) j++;
            }
        }
        return res;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int tar = target - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = j + 1;
                while (k < nums.length && (nums[j] + nums[k] < tar))
                    k++;
                if (k == nums.length)
                    result = (Math.abs(tar - nums[j] - nums[nums.length - 1]) > Math.abs(result)) ?
                            result : (tar - nums[j] - nums[nums.length - 1]);
                else if (k == (j + 1)) {
                    result = (Math.abs(tar - nums[j] - nums[k]) > Math.abs(result)) ?
                            result : (tar - nums[j] - nums[k]);
                } else {
                    k = (Math.abs(tar - nums[j] - nums[k]) > Math.abs(tar - nums[j] - nums[k - 1])) ? (k - 1) : k;
                    result = (Math.abs(tar - nums[j] - nums[k]) > Math.abs(result)) ?
                            result : (tar - nums[j] - nums[k]);
                }
            }
        }
        return target - result;
    }
}
