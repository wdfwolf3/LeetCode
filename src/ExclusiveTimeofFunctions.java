import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/7/16.
 */
public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, index = 0; i < logs.size(); i++) {
            String[] strings = logs.get(i).split(":");
            if ("start".equals(strings[1])){
                int p = Integer.parseInt(strings[2]);
                if (!stack.isEmpty())
                    ans[stack.peek()] = ans[stack.peek()] + (p-index);
                stack.push(Integer.parseInt(strings[0]));
                index = p;
            }else {
                int p = stack.pop();
                int i1 = Integer.parseInt(strings[2]);
                ans[p] = ans[p] + (i1 +1 -index);
                index = i1 + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"0:start:0",
                "1:start:2",
                "1:end:5",
                "2:start:6",
                "2:end:7",
                "0:end:8"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(strings[i]);
        }
        System.out.println(new ExclusiveTimeofFunctions().exclusiveTime(3, list));
    }
}
