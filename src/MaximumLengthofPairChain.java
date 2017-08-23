import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wdfwolf3 on 2017/7/23.
 */
public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 3}, {1, 5}, {1, 3}, {3, 4}};
        String string = "";
        System.out.println(new MaximumLengthofPairChain().findLongestChain(nums));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] <= o2[1] ? (o1 == o2 ? 0 : -1) : 1;
            }
        });
        int ans = 1, p = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > p) {
                ans++;
                p = pairs[i][1];
            }
        }
        return ans;
    }
}
