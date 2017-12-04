import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/11/6.
 */
public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (String s = ""; j < words[i].length(); j++) {
                s += words[i].charAt(j);
                if (!set.contains(s))
                    break;
            }
            if (j == words[i].length() && (words[i].length() > ans.length() || (words[i].length() == ans.length() &&
                    words[i].compareTo(ans) < 0)))
                ans = words[i];
        }
        return ans;
    }
}
