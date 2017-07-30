/**
 * Created by wdfwolf3 on 2017/6/19.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private int help(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        if (nums[mid] > nums[right])
            return help(nums, mid + 1, right);
        else
            return help(nums, left, mid);
    }
}
