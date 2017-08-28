public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int ans = 0;
        boolean[] sign = new boolean[M.length];
        for (int i = 0; i < sign.length; i++) {
            M[i][i] = 0;
            if (!sign[i]) {
                help(M, sign, i);
                ans++;
            }
        }
        return ans;
    }

    public void help(int[][] M, boolean[] sign, int index) {
        sign[index] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[index][i] == 1 && sign[0]) {
                M[index][i] = M[i][index] = 0;
                help(M, sign, i);
            }
        }
    }
}
