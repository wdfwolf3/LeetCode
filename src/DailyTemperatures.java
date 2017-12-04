import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/12/4.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] minIndex = new int[101];
        Arrays.fill(minIndex, Integer.MAX_VALUE);
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            minIndex[temperatures[i]] = i;
            int min = temperatures.length;
            for (int j = temperatures[i] + 1; j < 101; j++)
                min = Math.min(min, minIndex[j]);
            if (min != temperatures.length)
                ans[i] = min - i;
        }
        return ans;
    }
}
