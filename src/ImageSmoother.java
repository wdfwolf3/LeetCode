/**
 * Created by wdfwolf3 on 2017/8/20.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {

        if (M.length == 1) {
            if (M[0].length == 1)
                return M;
            int[][] ans = new int[M.length][M[0].length];
            for (int i = 0; i < M[0].length; i++) {
                if (i == 0)
                    ans[0][i] = (M[0][i] + M[0][i + 1]) / 2;
                else if (i == M[0].length - 1)
                    ans[0][i] = (M[0][i] + M[0][i - 1]) / 2;
                else
                    ans[0][i] = (M[0][i - 1] + M[0][i] + M[0][i + 1]) / 3;
            }
            return ans;
        } else if (M[0].length == 1) {
            int[][] ans = new int[M.length][M[0].length];
            for (int i = 0; i < M.length; i++) {
                if (i == 0)
                    ans[i][0] = (M[i][0] + M[i + 1][0]) / 2;
                else if (i == M.length - 1)
                    ans[i][0] = (M[i][0] + M[i - 1][0]) / 2;
                else
                    ans[i][0] /= (M[i - 1][0] + M[i][0] + M[i + 1][0]) / 3;
            }
            return ans;
        } else {
            int[][] ans = new int[M.length][M[0].length];
            for (int i = 0; i < M.length; i++) {
                ans[i][0] = M[i][0] + M[i][1];
                for (int j = 1; j < M[0].length - 1; j++) {
                    ans[i][j] = M[i][j - 1] + M[i][j] + M[i][j + 1];
                }
                ans[i][M[i].length - 1] = M[i][M[i].length - 1] + M[i][M[i].length - 2];
            }
            int[][] ans0 = new int[M.length][M[0].length];
            for (int i = 0; i < M[0].length; i++) {
                ans0[0][i] = ans[0][i] + ans[1][i];
                for (int j = 1; j < M.length - 1; j++) {
                    ans0[j][i] = ans[j - 1][i] + ans[j][i] + ans[j + 1][i];
                }
                ans0[M.length - 1][i] = ans[M.length - 1][i] + ans[M.length - 2][i];
            }
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if ((i == 0 && (j == 0 || j == M[i].length - 1)) || (i == M.length - 1 && (j == 0 || j == M[i].length - 1)))
                        ans0[i][j] /= 4;
                    else if (i == 0 || j == 0 || i == M.length - 1 || j == M[i].length - 1)
                        ans0[i][j] /= 6;
                    else
                        ans0[i][j] /= 9;
                }
            }
            return ans0;
        }
    }
}
