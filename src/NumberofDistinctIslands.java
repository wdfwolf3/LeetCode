import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/10/8.
 */
public class NumberofDistinctIslands {
    private int row, col;
    private int l, r, u, d;

    public int numDistinctIslands(int[][] grid) {
        row = grid.length - 1;
        if (row == -1)
            return 0;
        col = grid[0].length - 1;
        Set<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= col; j++)
                if (grid[i][j] == 1) {
                    r = d = 0;
                    l = col;
                    u = row;
                    dfs(grid, i, j);
                    List<List<Integer>> lists = new ArrayList<>();
                    for (int k = u; k <= d; k++) {
                        List<Integer> list = new ArrayList<>();
                        for (int m = l; m <= r; m++) {
                            if (grid[k][m] == 1)
                                list.add(0);
                            else if (grid[k][m] == 0)
                                list.add(0);
                            else {
                                list.add(grid[k][m]);
                                grid[k][m] = 0;
                            }
                        }
                        lists.add(list);
                    }
                    set.add(lists);
                }
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i >= 0 && i <= row && j >= 0 && j <= col && grid[i][j] > 0) {
            grid[i][j] = -1;
            l = Math.min(l, j);
            r = Math.max(r, j);
            u = Math.min(u, i);
            d = Math.max(d, i);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
