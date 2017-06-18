/**
 * Created by wdfwolf3 on 2017/6/18.
 */
public class MinimumFactorization {
    public int smallestFactorization(int a) {
        if(a<10)
            return a;
        int ans = 0;
        for (int i = (int) Math.sqrt(a); i > 1; i++) {
            if (a % i == 0){
                int n = smallestFactorization(i);
                if (n==0)
                    continue;
                int j = smallestFactorization(a/i);
                if (j!=0){
                    int tmp = help(n, j);
                    if (tmp != 0)
                }
            }
        }
    }
}
