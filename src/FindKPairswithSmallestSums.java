import java.util.*;

public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = o1[0] + o1[1], sum2 = o2[0] + o2[1];
                return sum1 > sum2 ? -1 : sum1 == sum2 ? 0 : 1;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] pair = new int[2];
                pair[0] = nums1[i];
                pair[1] = nums2[j];
                queue.add(pair);
                if (queue.size() > k)
                    queue.poll();
            }
        }
        List<int[]> ans = new ArrayList<>();
        for (int[] pair : queue)
            ans.add(pair);
        Collections.reverse(ans);
        return ans;
    }
}
