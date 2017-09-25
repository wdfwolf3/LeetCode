public class UniquePathsII {
    public static void main(String args[]) {
        int[][] nums = {{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i, len = obstacleGrid.length, len0 = obstacleGrid[0].length;
        int[] v = new int[len];
        for (i = 0; i < len; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            else
                v[i] = 1;
        }
        for (; i < len; i++) {
            v[i] = 0;
        }
        for (int j = 1; j < len0; j++) {
            for (i = 0; i < len; i++) {
                if (obstacleGrid[i][j] == 1)
                    v[i] = 0;
                else if (i != 0)
                    v[i] = v[i - 1] + v[i];
            }
        }
        return v[len - 1];
    }
}
