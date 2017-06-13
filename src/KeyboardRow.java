import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/5/31.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        int[] alphabet = new int[]{2,4,4,2,1,2,2,2,1,2,2,2,4,4,1,1,1,1,2,1,1,4,1,4,1,4,0,0,0,0,0,0,2,4,4,2,1,2,2,2,1,2,2,2,4,4,1,1,1,1,2,1,1,4,1,4,1,4};
        List<String> list = new ArrayList<>();
        for (String word : words){
            int tmp = 7;
            for (char c : word.toCharArray()){
                tmp = tmp & alphabet[c-'A'];
                if(tmp == 0)
                    break;
            }
            if(tmp != 0)
                list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
}
