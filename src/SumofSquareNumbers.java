/**
 * Created by wdfwolf3 on 2017/7/2.
 */
public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i <= c; i++) {
            if (i*i>c)
                break;
            int tmp = (int) (c - i*i);
            int tmp1 = (int) Math.sqrt(tmp);
            if (tmp1*tmp1 == tmp)
                return true;
        }
        return false;
    }
}
