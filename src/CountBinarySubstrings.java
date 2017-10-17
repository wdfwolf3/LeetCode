import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/10/15.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c)
                count++;
            list.add(count);
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++)
            ans += Math.min(list.get(i), list.get(i - 1));
        return ans;
    }
}
