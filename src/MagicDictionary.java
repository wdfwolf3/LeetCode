import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
class MagicDictionary {
    private Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {

    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        map = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            if (map.containsKey(dict[i].length()))
                map.get(dict[i].length()).add(dict[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(dict[i]);
                map.put(dict[i].length(), list);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        if (!map.containsKey(word.length()))
            return false;
        List<String> list = map.get(word.length());
        for (String s : list) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    count++;
                    if (count > 1)
                        break;
                }
            }
            if (count == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
//        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
//        System.out.println(magicDictionary.search("hell"));
//        System.out.println(magicDictionary.search("leetcoded"));
    }
}
