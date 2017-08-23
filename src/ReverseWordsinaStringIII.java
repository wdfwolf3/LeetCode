/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (end = 0; end < s.length(); end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        reverse(chars, start, end - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
