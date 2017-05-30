/**
 * Created by wdfwolf3 on 2017/5/29.
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length == 0)
            return m * n;
        int down = m, right = n;
        for (int[] op : ops){
            down = Math.min(down, op[0]);
            right = Math.min(right, op[1]);
        }
        return down * right;
    }
}
