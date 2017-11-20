import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? -1 : o2.getValue() == o1.getValue() ? o2.getKey().compareTo(o1.getKey()) : 1;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> ans = new ArrayList<>();
        while (queue.size() > 0)
            ans.add(queue.poll().getKey());
        Collections.reverse(ans);
        return ans;
    }
}
