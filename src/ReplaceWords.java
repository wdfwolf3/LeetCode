import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/7/23.
 */
public class ReplaceWords {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 3}, {1, 5}, {1, 3}, {3, 4}};
        String string = "";
        List<String> dict = new ArrayList<>();
        System.out.println(new ReplaceWords().replaceWords(dict, string));
    }

    public String replaceWords(List<String> dict, String sentence) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            for (String s : dict) {
                if (strings[i].startsWith(s)) {
                    strings[i] = s;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i] + " ");
        }
        return stringBuilder.toString().trim();
    }
}
