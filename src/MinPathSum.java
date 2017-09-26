public class MinPathSum {
    public static void main(String args[]) {
        int[][] nums = {{0, 1, 2, 4}, {3, 4, 7, 3}, {4, 5, 3, 7}};
        System.out.println(minPathSum(nums));
    }

    public static int minPathSum(int[][] grid) {
        int len = grid.length, len0 = grid[0].length;
        int[] v = new int[len];
        for (int i = 0, sum = 0; i < len; i++) {
            sum += grid[i][0];
            v[i] = sum;
        }
        for (int j = 1; j < len0; j++) {
            for (int i = 0; i < len; i++) {
                if (i == 0)
                    v[i] += grid[i][j];
                else
                    v[i] = Math.min(v[i - 1], v[i]) + grid[i][j];
            }
        }
        return v[len - 1];
    }
}
