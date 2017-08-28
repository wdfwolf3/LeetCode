/**
 * Created by wdfwolf3 on 2017/5/31.
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length)
            return nums;
        int[][] ans = new int[r][c];
        int c0 = nums[0].length;
        for (int i = 0, tmpI = 0, tmpJ = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[tmpI][tmpJ];
                if (tmpJ == c0 - 1) {
                    tmpI++;
                    tmpJ = 0;
                } else
                    tmpJ++;
            }
        }
        return ans;
    }
}
