import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/9/24.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("C"))
                stack.pop();
            else if (s.equals("D"))
                stack.push(stack.peek() * 2);
            else if (s.equals("+")) {
                int tmp = stack.pop();
                int push = tmp + stack.peek();
                stack.push(tmp);
                stack.push(push);
            } else
                stack.push(Integer.parseInt(s));
        }
        int ans = 0;
        for (Integer i : stack)
            ans += i;
        return ans;
    }
}
