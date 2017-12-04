public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length < 2)
            return nums.length-1;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++)
            right+= nums[i];
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right)
                return i;
            left += nums[i];
        }
        return -1;
    }
}
