import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String args[]) {
        System.out.println(calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        System.out.println(s);
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> in = new Stack<>();
        for (int i = 0; i < len; ) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                stack.push(c);
                i++;
            } else if (c == '*') {
                int tmp = s.charAt(++i) - '0';
                i++;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + (s.charAt(i++) - '0');
                }
                in.push(in.pop() * tmp);
            } else if (c == '/') {
                int tmp = s.charAt(++i) - '0';
                i++;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + (s.charAt(i++) - '0');
                }
                in.push(in.pop() / tmp);
            } else {
                int tmp = s.charAt(i++) - '0';
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + (s.charAt(i++) - '0');
                }
                in.push(tmp);
            }
        }
        int result = 0;
        while (!stack.empty()) {
            result += (stack.pop().equals('+') ? in.pop() : (-1) * in.pop());
        }
        return result + in.pop();
    }
}
