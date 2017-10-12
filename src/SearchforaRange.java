public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0)
            return ans;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target)
                r = m - 1;
            else {
                l = m + 1;
                if (nums[m] == target)
                    ans[1] = m;
            }
        }
        if (ans[1] == -1)
            return ans;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target)
                l = m + 1;
            else {
                r = m - 1;
                if (nums[m] == target)
                    ans[0] = m;
            }
        }
        return ans;
    }
}
