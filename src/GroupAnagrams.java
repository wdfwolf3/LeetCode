import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
    public static void main(String args[]) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String s1 = new String(tmp);
            if (map.containsKey(s1)) {
                map.get(s1).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1, list);
            }
        }
        for (Entry<String, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
