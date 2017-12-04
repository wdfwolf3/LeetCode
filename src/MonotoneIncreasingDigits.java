/**
 * Created by wdfwolf3 on 2017/12/4.
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10)
            return N;
        char[] ns = String.valueOf(N).toCharArray();
        for (int i = 1; i < ns.length; i++) {
            if (ns[i] < ns[i - 1]) {
                for (; i > 0; i--)
                    if (ns[i] < ns[i - 1])
                        ns[i - 1] = (char) (ns[i - 1] - 1);
                    else
                        break;
                for (i = i + 1; i < ns.length; i++)
                    ns[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(ns));
    }
}
