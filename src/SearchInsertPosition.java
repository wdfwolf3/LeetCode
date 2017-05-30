/**
 * Created by wdfwolf3 on 2017/5/24.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int middle = (left+right)/2;
            if(nums[middle] == target)
                return middle;
            else if(nums[middle] > target)
                right = middle;
            else
                left = middle;
        }
        return right;
    }
}
