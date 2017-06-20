import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/18.
 */
public class MinimumFactorization {
    public int smallestFactorization(int a) {
        if (a < 10) return a;
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                a /= i;
                list.add(i);
            }
        }
        if (a > 1 || list.size() > 10) return 0;
        long ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans = ans * 10 + list.get(i);
        }
        return (ans > Integer.MAX_VALUE) ? 0 : (int) ans;
    }
}
