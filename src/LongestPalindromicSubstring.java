public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        String s = "abcdcsddddscdc";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int start = 0, max = 0, i = 0, len = s.length();
        for (i = 0; i < len; i++) {
            int sta = i;
            while (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
            int m = sta, n = i;
            while (m > 0 && n < len - 1 && s.charAt(m - 1) == s.charAt(n + 1)) {
                m--;
                n++;
            }
            if (n - m + 1 > max) {
                max = n - m + 1;
                start = m;
            }
        }
        return s.substring(start, start + max);
    }
}
