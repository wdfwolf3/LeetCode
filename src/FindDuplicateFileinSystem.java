import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/6/4.
 */
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                int index = files[i].indexOf('(');
                String content = files[i].substring(index, files[i].length() - 1);
                if (!map.containsKey(content))
                    map.put(content, new ArrayList<>());
                map.get(content).add(files[0] + "/" + files[i].substring(0, index));
            }
        }
        for (List<String> list : map.values())
            if (list.size() > 1)
                ans.add(list);
        return ans;
    }
}
