/**
 * Created by wdfwolf3 on 2017/5/23.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num < 6)
            return false;
        int sum = 1, max = num/2;
        for (int i = 2; i < max; i++) {
            if(num % i == 0)
                sum = sum + i + num/i;
            max = num/i;
        }
        return num==sum;
    }
}
