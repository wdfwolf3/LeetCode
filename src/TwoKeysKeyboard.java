public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        else if (n < 6)
            return n;
        int ans = n, end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) {
                int m = n / i;
                ans = Math.min(ans, minSteps(i) + m);
                ans = Math.min(ans, minSteps(m) + i);
            }
        }
        return ans;
    }
}
