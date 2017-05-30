/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1)
            return true;
        boolean isCapital = Character.isUpperCase(word.charAt(1));
        if(isCapital && !Character.isUpperCase(word.charAt(0)))
            return false;
        for (int i = 2; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i)) != isCapital)
                return false;
        }
        return true;
    }
}
