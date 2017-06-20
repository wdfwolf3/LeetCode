import java.util.Random;

/**
 * Created by wdfwolf3 on 2017/6/20.
 */
public class RandomPickIndex {
    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(++count) == 0) index = i;
            }
        }
        return index;
    }
}
