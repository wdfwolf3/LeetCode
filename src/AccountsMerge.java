import java.util.*;

/**
 * Created by wdfwolf3 on 2017/11/6.
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            List<Set<String>> list1 = map.getOrDefault(name, new ArrayList<>());
            List<Set<String>> newList = new ArrayList<>();
            Set<String> tmp = new HashSet<>(list.subList(1, list.size()));
            for (Set<String> set : list1) {
                boolean flag = false;
                for (String s : set)
                    if (tmp.contains(s)) {
                        flag = true;
                        break;
                    }
                if (flag)
                    tmp.addAll(set);
                else
                    newList.add(set);
            }
            newList.add(tmp);
            map.put(name, newList);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : map.entrySet()) {
            String name = entry.getKey();
            for (Set<String> set : entry.getValue()) {
                List<String> list = new ArrayList<>();
                list.add(name);
                list.addAll(set);
                Collections.sort(list);
                ans.add(list);
            }
        }
        return ans;
    }
}
