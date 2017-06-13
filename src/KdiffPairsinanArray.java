import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/5/23.
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = 1; i<nums.length && j < nums.length;) {
            int tmp = Math.abs(nums[j]-nums[i]);
            if(tmp == k){
                ans++;
                i++;
                while (i<nums.length && nums[i]==nums[i-1])
                    i++;
                if(i < nums.length-1){
                    if(j<i)
                        j=i+1;
                    else{
                        while (j<nums.length-1 && nums[j]==nums[j+1])
                            j++;
                        j++;
                    }
                }else
                    return ans;
            }else if (tmp > k){
                i++;
                while (i<nums.length && nums[i]==nums[i-1])
                    i++;
                if(j<=i)
                    j=i+1;
            }
            else{
                j++;
                while (j<nums.length && nums[j]==nums[j-1])
                    j++;
            }
        }
        return ans;
    }
}
