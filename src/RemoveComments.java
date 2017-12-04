import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/11/6.
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        String tmp = "";
        boolean flag = false;
        for (int i = 0; i < source.length; i++) {
            String s = source[i];
            if (flag)
                if (s.contains("*/")) {
                    flag = false;
                    s = tmp + s.substring(s.indexOf("*/") + 2);
                    tmp = "";
                } else
                    continue;
            int one = s.indexOf("//"), mul = s.indexOf("/*");
            if (one >= 0 && mul >= 0 && mul < one)
                one = -1;
            if (one >= 0)
                s = s.substring(0, one);
            else if (mul >= 0) {
                tmp = s.substring(0, s.indexOf("/*"));
                source[i--] = s.substring(s.indexOf("/*") + 2);
                flag = true;
                s = "";
            }
            if (!s.equals(""))
                ans.add(s);
        }
        return ans;
    }
}
