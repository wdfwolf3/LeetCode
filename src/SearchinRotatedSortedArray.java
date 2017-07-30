/**
 * Created by wdfwolf3 on 2017/6/19.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        return help(nums, 0, nums.length - 1, target);
    }


    private int help(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        if (left == right)
            return nums[left] == target ? left : -1;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[right]) {
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                if (help(nums, left, mid - 1, target) != -1)
                    return help(nums, left, mid - 1, target);
                if (help(nums, mid + 1, right, target) != -1)
                    return help(nums, mid + 1, right, target);
                return -1;
            } else
                return help(nums, mid + 1, right, target);
        } else {
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                return help(nums, left, mid - 1, target);
            } else {
                if (help(nums, left, mid - 1, target) != -1)
                    return help(nums, left, mid - 1, target);
                if (help(nums, mid + 1, right, target) != -1)
                    return help(nums, mid + 1, right, target);
                return -1;
            }
        }
    }
}
