/**
 * 动态规划，F(n) = F(n-1) + p(n-1)*(n-1);
 * 其中n即数字的位数，F(n)为不符合的个数，p(n)为n位数不符合的个数
 * Created by wdfwolf3 on 2017/2/14.
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int n = 12;
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(n));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 2)
            return (int) Math.pow(10, n);
        if (n > 10)
            return 8877691;
        int p = 9, f = 10;
        for (int i = 2; i <= n; i++) {
            p = p * (10 - i + 1);
            f += p;
        }
        return f;
    }
}
