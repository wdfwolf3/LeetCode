import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/5/12.
 */
public class Find132Pattern {
    //159ms
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                i++;
            }
            int one = nums[i++];
            while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                i++;
            }
            if (i >= nums.length - 1) {
                return false;
            }
            int three = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > one && nums[j] < three) {
                    return true;
                }
            }
        }
        return false;
    }

    //30ms
    public boolean find132pattern1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int two = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < two) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                two = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
