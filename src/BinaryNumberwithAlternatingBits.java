/**
 * Created by wdfwolf3 on 2017/10/8.
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        boolean flag = n % 2 == 0 ? true : false;
        n /= 2;
        while (n != 0) {
            int tmp = n % 2;
            if (tmp == 0 && flag)
                return false;
            if (tmp == 1 && !flag)
                return false;
            flag = !flag;
            n /= 2;
        }
        return true;
    }
}
