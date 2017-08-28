import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/15.
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        List<String> ans = new ArrayList<>();
        int maxLength = 0;
        for (String string : d) {
            int i = 0;
            for (int j = 0; i < string.length(); i++, j++) {
                char c = string.charAt(i);
                while (j < s.length() && c != s.charAt(j))
                    j++;
                if (j == s.length())
                    break;
            }
            if (i == string.length()) {
                if (i > maxLength) {
                    ans = new ArrayList<>();
                    ans.add(string);
                    maxLength = i;
                } else if (i == maxLength)
                    ans.add(string);
            }
        }
        if (ans.size() == 0)
            return "";
        System.out.println(ans.size());
        Collections.sort(ans);
        return ans.get(0);
    }
}
