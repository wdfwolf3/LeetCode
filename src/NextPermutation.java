/**
 * Created by wdfwolf3 on 2017/5/31.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>=0 && nums[i] < nums[i+1])
            i--;
        if (i < 0)
            i=0;
        else {
            for (int j = nums.length -1; j > i; j--) {
                if (nums[j] > nums[i]){
                    int tmp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
        for (int j = nums.length-1; j > i; j--,i++) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return;
    }
}
