/**
 * Created by wdfwolf3 on 2017/5/23.
 */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] n1 = new int[26];
        int[] n2 = new int[26];
        for (int i = 0; i < s1.length(); i++)
            n1[s1.charAt(i)-'a'] = n1[s1.charAt(i)-'a']+1;
        int j;
        for (j = 0; j < s1.length(); j++)
            n2[s2.charAt(j) - 'a'] = n2[s2.charAt(j) - 'a'] + 1;
        for (int i = 0; j < s2.length(); i++,j++) {
            int k;
            for (k = 0; k < 26; k++)
                if(n1[k]!=n2[k])
                    break;
            if(k==26)
                return true;
            n2[s2.charAt(i) - 'a'] = n2[s2.charAt(i) - 'a'] - 1;
            n2[s2.charAt(j) - 'a'] = n2[s2.charAt(j) - 'a'] + 1;
        }
        for (int k = 0; k < 26; k++)
            if(n1[k]!=n2[k])
                return false;
        return true;
    }
}
