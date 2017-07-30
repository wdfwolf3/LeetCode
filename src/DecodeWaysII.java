/**
 * Created by wdfwolf3 on 2017/7/9.
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        double sta = Math.pow(10, 9) + 7;
        double be2 = 1, be1 = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            double be = 0;
            if (c == '*')
                be = 9 * be1;
            else if (c != '0')
                be = be1;
            if (s.charAt(i - 1) == '*' && c == '*') {
                be += 15 * be2;
            } else if (s.charAt(i - 1) == '*') {
                if ((c - '0') <= 6 && (c - '0') >= 0)
                    be += 2 * be2;
                else
                    be += be2;
            } else if (c == '*') {
                switch (s.charAt(i - 1)) {
                    case '1':
                        be += 9 * be2;
                        break;
                    case '2':
                        be += 6 * be2;
                        break;
                    default:
                        break;
                }
            } else if (s.charAt(i - 1) != '0') {
                int tmp = Integer.parseInt(s.substring(i - 1, i + 1));
                if (tmp <= 26)
                    be += be2;
            }
            be2 = be1;
            be1 = be % sta;
        }
        return (int) be1;
    }
}
