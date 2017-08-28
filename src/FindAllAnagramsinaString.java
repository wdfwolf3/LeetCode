import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/24.
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<Integer>();
        int[] anagram = new int[26];
        for (int i = 0; i < p.length(); i++) {
            anagram[p.charAt(i) - 'a']++;
        }
        int i;
        for (i = 0; i < p.length(); i++) {
            anagram[s.charAt(i) - 'a']--;
        }
        List<Integer> ans = new ArrayList<>();
        if (isZero(anagram))
            ans.add(0);
        for (int j = 0; i < s.length(); j++, i++) {
            anagram[s.charAt(i) - 'a']--;
            anagram[s.charAt(j) - 'a']++;
            if (isZero(anagram))
                ans.add(j + 1);
        }
        return ans;
    }

    public boolean isZero(int[] anagram) {
        for (int i : anagram) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
