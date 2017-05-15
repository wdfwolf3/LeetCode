import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/5/13.
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println((new DecodeString()).decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        String current = "";
        Stack<Integer> numbers = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int j = i+1;
                while (Character.isDigit(s.charAt(j)))
                    j++;
                numbers.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            }else if (Character.isAlphabetic(c)){
                current += c;
            }else if(c == '['){
                stringStack.push(current);
                current = "";
            }else {
                int count = numbers.pop();
                StringBuilder tmp = new StringBuilder(current);
                for (int j = 1; j < count; j++) {
                    tmp.append(current);
                }
                current = stringStack.pop() + tmp.toString();
            }
        }
        return current;
    }
}
