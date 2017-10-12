public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 3)
            return true;
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        if (s.equals(stringBuilder.toString()))
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                break;
            l++;
            r--;
        }
        int tmpl = l, tmpr = r--;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                break;
            l++;
            r--;
        }
        if (l >= r)
            return true;
        l = ++tmpl;
        r = tmpr;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
