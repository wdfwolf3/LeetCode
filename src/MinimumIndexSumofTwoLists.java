import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/5/29.
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int indexSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                if(map.get(list2[i]) + i < indexSum){
                    indexSum = map.get(list2[i])+i;
                    list = new ArrayList<>();
                    list.add(list2[i]);
                }else if (map.get(list2[i]) + i == indexSum)
                    list.add(list2[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
