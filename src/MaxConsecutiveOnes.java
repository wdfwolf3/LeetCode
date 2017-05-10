/**
 * Created by admin on 2017/1/15.
 */
public class MaxConsecutiveOnes {
    public static void main(String args[]){
        int[] nums = {0,0,0,1,1,1,0,0,1,0};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int ans = 0, count = 0;
        for(int i=0;i<len;){
            while(i<len&&nums[i++]==1){
                count++;
            }
            if(count>ans){
                ans = count;
            }
            count = 0;
        }
        return ans;
    }
}
