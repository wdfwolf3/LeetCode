import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/5/8.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length && index < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        for (Integer i : stack){
            ans[i] = -1;
        }
        return ans;
    }
}
