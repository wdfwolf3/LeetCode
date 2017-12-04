import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer>[] sign = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (sign[entry.getValue()] == null)
                sign[entry.getValue()] = new ArrayList<>();
            sign[entry.getValue()].add(entry.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = sign.length - 1, sum = 0; i >= 0; i--)
            if (sum >= k)
                break;
            else if (sign[i] != null) {
                sum += sign[i].size();
                ans.addAll(sign[i]);
            }
        return ans;
    }
}
