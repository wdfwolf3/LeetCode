/**
 * Created by wdfwolf3 on 2017/10/8.
 */
public class MaxAreaofIsland {
    private int max;
    private boolean[][] sign;
    private int row, col;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        if (row == 0)
            return 0;
        col = grid[0].length;
        sign = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !sign[i][j])
                    dfs(grid, i, j);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        int ans = 1;
        sign[i][j] = true;
        if (j + 1 < col && grid[i][j + 1] == 1 && !sign[i][j + 1])
            ans += dfs(grid, i, j + 1);
        if (i + 1 < row && grid[i + 1][j] == 1 && !sign[i + 1][j])
            ans += dfs(grid, i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !sign[i][j - 1])
            ans += dfs(grid, i, j - 1);
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !sign[i - 1][j])
            ans += dfs(grid, i - 1, j);
        max = Math.max(max, ans);
        return ans;
    }
}
