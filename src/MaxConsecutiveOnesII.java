/**
 * Created by admin on 2017/1/15.
 */
public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,0};
        System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int lastMaxOnes = 0, thisMaxOnes = 0, i = 0;
        while(i<len&&nums[i]==1) {
            lastMaxOnes++;
            i++;
        }
        if(i==len)
            return (lastMaxOnes>0)?len:1;
        int ans = lastMaxOnes+1;
        for (;i<len;) {
            if(nums[i]==0){
                int countZeros = 0;
                i++;
                while (i<len&&nums[i]==0){
                    countZeros++;
                    i++;
                }
                if (countZeros>0){
                    ans = (lastMaxOnes+1>ans)?(lastMaxOnes+1):ans;
                    lastMaxOnes = 0;
                }
                else
                    continue;
            }
            else{
                while (i<len&&nums[i]==1){
                    thisMaxOnes++;
                    i++;
                }
                if(lastMaxOnes+thisMaxOnes+1>ans){
                    ans = lastMaxOnes + thisMaxOnes + 1;
                }
                lastMaxOnes = thisMaxOnes;
                thisMaxOnes = 0;
            }

        }
        return (lastMaxOnes +1+thisMaxOnes>ans)?(lastMaxOnes+1+thisMaxOnes):ans;
    }
}
