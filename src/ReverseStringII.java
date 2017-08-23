/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int left = 0, right = k - 1;
        char[] chars = s.toCharArray();
        for (; right < s.length(); left += 2 * k, right += 2 * k) {
            int l = left, r = right;
            while (l < r) {
                char c = chars[l];
                chars[l++] = chars[r];
                chars[r--] = c;
            }
        }
        if (left < s.length()) {
            int l = left, r = s.length() - 1;
            while (l < r) {
                char c = chars[l];
                chars[l++] = chars[r];
                chars[r--] = c;
            }
        }
        return new String(chars);
    }
}
