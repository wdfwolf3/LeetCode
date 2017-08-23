/**
 * Created by admin on 2017/1/15.
 */
public class MaxConsecutiveOnes {
    public static void main(String args[]) {
        int[] nums = {0, 0, 0, 1, 1, 1, 0, 0, 1, 0};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;
        for (Integer i : nums) {
            if (i == 0) {
                if (count > ans)
                    ans = count;
                count = 0;
            } else
                count++;
        }
        return Math.max(ans, count);
    }
}
