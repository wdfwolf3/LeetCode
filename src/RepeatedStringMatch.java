/**
 * Created by wdfwolf3 on 2017/10/1.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int length = B.length() / A.length() + 2;
        String tmp = A;
        for (int i = 0; i < length; i++) {
            if (A.contains(B))
                return i + 1;
            else
                A += tmp;
        }
        return -1;
    }
}
