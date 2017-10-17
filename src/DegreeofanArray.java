import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/10/15.
 */
public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0, tmp = nums[0]; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                int[] ints = map.get(n);
                ints[0]++;
                ints[2] = i;
            } else {
                int[] ints = new int[3];
                ints[0] = 1;
                ints[1] = i;
                map.put(n, ints);
            }
        }
        int ans = Integer.MAX_VALUE, max = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] tmp = entry.getValue();
            if (tmp[0] > max) {
                max = tmp[0];
                ans = (tmp[2] - tmp[1] > 0) ? (tmp[2] - tmp[1] + 1) : 1;
            } else if (tmp[0] == max) {
                ans = Math.min(ans, (tmp[2] - tmp[1] > 0) ? (tmp[2] - tmp[1] + 1) : 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DegreeofanArray d = new DegreeofanArray();
        int[] nums = {1, 2, 3, 4};
        System.out.println(d.findShortestSubArray(nums));
    }
}
