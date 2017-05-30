/**
 * Created by wdfwolf3 on 2017/5/24.
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if(s.charAt(i)!=' '){
                while (i<s.length() && s.charAt(i)!=' ')
                    i++;
                ans++;
            }else
                i++;
        }
        return ans;
    }
}
