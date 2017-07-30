/**
 * Created by wdfwolf3 on 2017/6/19.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public int help(int[] nums, int left, int right) {
        if (right - left == 0)
            return left;
        if (right - left == 1)
            return nums[right] > nums[left] ? right : left;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        else if (nums[mid] > nums[mid - 1])
            return help(nums, mid + 1, right);
        else
            return help(nums, left, mid - 1);
    }
}
