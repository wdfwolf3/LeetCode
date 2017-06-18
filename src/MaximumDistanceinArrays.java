/**
 * Created by wdfwolf3 on 2017/6/18.
 */
public class MaximumDistanceinArrays {
    public int maxDistance(int[][] arrays) {
        int ans = 0, min = arrays[0][0], max = arrays[0][arrays[0].length-1];
        for (int i = 1; i < arrays.length; i++) {
            ans = Math.max(ans, Math.max(Math.abs(arrays[i][arrays[i].length-1]-min), Math.abs(max - arrays[i][0])));
            min = Math.min(min, arrays[i][0]);
            max = Math.max(max, arrays[i][arrays[i].length-1]);
        }
        return ans;
    }
}
