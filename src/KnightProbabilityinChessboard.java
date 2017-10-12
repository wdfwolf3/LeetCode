import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/10/1.
 */
public class KnightProbabilityinChessboard {
    public static void main(String[] args) {
        KnightProbabilityinChessboard test3 = new KnightProbabilityinChessboard();
        System.out.println(test3.knightProbability(10, 13, 5, 3));
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0)
            return 1;
        if (N < 3)
            return 0;
        double[][] p = new double[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(p[i], 1);
        for (int i = 0; i < K; i++) {
            double[][] nextP = new double[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    double tmp = 0;
                    if (j + 2 < N && k + 1 < N)
                        tmp += p[j + 2][k + 1] / 8;
                    if (j + 2 < N && k - 1 >= 0)
                        tmp += p[j + 2][k - 1] / 8;
                    if (j - 2 >= 0 && k - 1 >= 0)
                        tmp += p[j - 2][k - 1] / 8;
                    if (j - 2 >= 0 && k + 1 < N)
                        tmp += p[j - 2][k + 1] / 8;
                    if (j + 1 < N && k + 2 < N)
                        tmp += p[j + 1][k + 2] / 8;
                    if (j + 1 < N && k - 2 >= 0)
                        tmp += p[j + 1][k - 2] / 8;
                    if (j - 1 >= 0 && k + 2 < N)
                        tmp += p[j - 1][k + 2] / 8;
                    if (j - 1 >= 0 && k - 2 >= 0)
                        tmp += p[j - 1][k - 2] / 8;
                    nextP[j][k] = tmp;
                }
            }
            p = nextP;
        }
        return p[r][c];
    }
}
