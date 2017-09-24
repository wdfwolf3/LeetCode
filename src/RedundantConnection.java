/**
 * Created by wdfwolf3 on 2017/9/24.
 */
public class RedundantConnection {
    private int[] parent = new int[2001];

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        int[] ans = new int[2];
        for (int[] nums : edges) {
            int t0 = find(nums[0]), t1 = find(nums[1]);
            if (t0 == t1)
                ans = nums;
            else
                parent[t0] = t1;
        }
        return ans;
    }

    public int find(int n) {
        while (n != parent[n])
            n = parent[n];
        return n;
    }
}


